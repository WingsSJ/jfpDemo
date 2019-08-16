package com.demo.grpc.service;

import com.demo.grpc.feginService.IRestCmsAdvisoryController;
import com.topsec.mobiapi.proto.*;
import com.topsec.util.ObjectUtil;
import com.topsec.util.json.JackJson;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * @auther jasonx
 * @create 5/25/18 1:24 PM
 **/
@Component
@Slf4j
public class NewsService extends NewsServGrpc.NewsServImplBase {
    @Autowired
    private IRestCmsAdvisoryController restCmsAdvisoryController;
    private JackJson jackJson;

    @Override
    public void getNews(GetNewsRequest request, StreamObserver<GetNewsResponse> responseObserver) {
        try {
            String whichColumn = request.getWhichColumn();
            if (ObjectUtil.isEmpty(whichColumn)) {
                whichColumn = "aqbb,cpdt,hydt";
            }
            PagingCondition pagingCond = request.getPagingCond();
            int currentPage = pagingCond.getCurrentPage();
            int sizePerPage = pagingCond.getSizePerPage();
            String newStr = restCmsAdvisoryController.restQueryCmsAdvisory(whichColumn, currentPage, sizePerPage, null, null);
            Map<String, Object> newsMap = jackJson.fromJsonObject(newStr);
            String result = ObjectUtil.parseString(newsMap.get("result"));
            if(!"success".equals(result)){
                responseObserver.onError(Status.INTERNAL
                        .withDescription("400700#查询新闻咨询失败!")
                        .asRuntimeException());
                return;
            }
            Map<String, NewsList> newDataMap=new HashMap<>();
            for (Map.Entry<String, Object> newEntry : newsMap.entrySet()) {
                String newType = newEntry.getKey();
                if(!newType.equals("result")){
                    List<Map<String,Object>> tyepNewList = (List<Map<String, Object>>)newEntry.getValue();
                    if(tyepNewList!=null){
                        List<News> news=new ArrayList<>();
                        for (Map<String, Object> newMap : tyepNewList) {
                            String uuid = ObjectUtil.parseString(newMap.get("uuid"));
                            String title = ObjectUtil.parseString(newMap.get("title"));
                            String author = ObjectUtil.parseString(newMap.get("author"));
                            String sortdate = ObjectUtil.parseString(newMap.get("sortdate"));
                            String path = ObjectUtil.parseString(newMap.get("path"));
                            String typeimg = ObjectUtil.parseString(newMap.get("typeimg"));
                            News newBuild = News.newBuilder()
                                    .setId(uuid)
                                    .setTitle(title)
                                    .setAuthor(author)
                                    .setPubDate(sortdate)
                                    .setHtmlUrl(path)
                                    .setImgUrl(typeimg)
                                    .setColumn(newType)
                                    .build();
                            news.add(newBuild);
                        }
                        PagingResult pagingResult= PagingResult.newBuilder()
                                .setCurrentPage(currentPage)
                                .setSizePerPage(sizePerPage)
                                .build();
                        NewsList newsList= NewsList.newBuilder().addAllNewsList(news).setPagingResult(pagingResult).build();
                        newDataMap.put(newType,newsList);
                    }
                }
            }
            GetNewsResponse news= GetNewsResponse.newBuilder().putAllNewsMap(newDataMap).build();
            responseObserver.onNext(news);
            responseObserver.onCompleted();
        }catch (Exception e){
            String uuid=UUID.randomUUID().toString();
            log.error("["+uuid+"] "+e.getMessage(),e);
            responseObserver.onError(Status.UNKNOWN.withDescription(uuid).asRuntimeException());
        }
    }
}

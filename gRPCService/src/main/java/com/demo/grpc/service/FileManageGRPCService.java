//package com.demo.grpc.service;
//
//import com.demo.common.module.DTO.FileInfoQueryDTO;
//import com.demo.common.module.DTO.FilePreViewQueryDTO;
//import com.demo.common.module.VO.JsonObject;
//import com.demo.common.module.VO.PageVO;
//import com.demo.grpc.feginService.FileManageFeginService;
//import com.demo.grpc.model.FilePreViewVO;
//import com.demo.grpc.model.FileTypeVO;
//import com.demo.grpc.model.FileTypeVOS;
//import com.demo.grpc.model.FileVO;
//import com.topsec.mobiapi.proto.*;
//import io.grpc.Status;
//import io.grpc.stub.StreamObserver;
//import lombok.extern.slf4j.Slf4j;
//import org.lognet.springboot.grpc.GRpcService;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.List;
//
//@GRpcService
//@Slf4j
//public class FileManageGRPCService extends FsmServiceGrpc.FsmServiceImplBase{
//    @Autowired
//    FileManageFeginService fileManageFeginService;
//
//    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
//    @Override
//    public void getFileList(FileQueryRequest request, StreamObserver<GetFileInfoResponse> responseObserver) {
//        //获取请求
//        log.info("getPageSize: {}", request.getPageSize());
//        log.info("getCurrPage: {}", request.getCurrPage());
//        log.info("times: {}", request.getTimes());
//        log.info("getSearchCondition: {}", request.getSearchCondition());
//        JsonObject<PageVO<FileVO>> fileVOPageVO = fileManageFeginService.getFileList(new FileInfoQueryDTO(
//                request.getPageSize(),
//                request.getCurrPage(),
//                request.getSearchCondition(),
//                request.getTimes()
//                ));
//
//        if (fileVOPageVO.getResult() != 0) {
//            responseObserver.onError(Status.NOT_FOUND
//                    .withDescription("查询文件信息失败!")
//                    .asRuntimeException());
//            return;
//        }
//        List<FileInfo> fileInfos = new ArrayList<>();
//        fileVOPageVO.getObjEntity().getList().forEach(dto ->
//                fileInfos.add(
//                        FileInfo.newBuilder().setFid(dto.getDocId()).
//                                setName(dto.getDocName()).
//                                setSize(dto.getDocSize()).
//                                setCategory(dto.getDocCategory()).
//                                setType(dto.getDocType()).
//                                setWatchUrl(dto.getWatchUrl()).
//                                setShareNumber(dto.getDocShareNumber()).
//                                setDownloadNumber(dto.getDocDownloadNumber()).
//                                setCreatedId(dto.getCreatedById()).
//                                setCreatedName(dto.getCreatedByName()).
//                                setUpdatedId(dto.getUpdatedById()).
//                                setUpdatedName(dto.getUpdatedByName()).
//                                setUtime(simpleDateFormat.format(dto.getUpdatedTime())).
//                                setVersion(dto.getDocVersion())
//                                .build()
//                )
//        );
//        Integer currPage = fileVOPageVO.getObjEntity().getCurrPage();
//        Integer totalCount = fileVOPageVO.getObjEntity().getTotalCount();
//        Integer pageSize = fileVOPageVO.getObjEntity().getPageSize();
//        int totalPage = (int) Math.ceil((double) totalCount / pageSize);
//        FileInfoEntity fileInfoEntity = FileInfoEntity.newBuilder().addAllList(fileInfos).setCurrPage(currPage).setPageSize(pageSize).setTotalCount(totalCount).setTotalPage(totalPage).build();
//        GetFileInfoResponse getFileInfoResponse
//                = GetFileInfoResponse.newBuilder().setObjEntity(fileInfoEntity).setMesssage("success").setResult(0).build();
//        responseObserver.onNext(getFileInfoResponse);
//        responseObserver.onCompleted();
//    }
//
//    /**
//     *  资料预览
//     */
//    @Override
//    public void getFileUrl(FileUrlRequest request, StreamObserver<FileUrlResponse> responseObserver) {
//        //获取请求
//        log.info("getFid: {}", request.getFid());
//        JsonObject<FilePreViewVO> filePreViewVOJsonObject = fileManageFeginService.getFileUrl(new FilePreViewQueryDTO(
//                request.getFid()
//        ));
//        if (filePreViewVOJsonObject.getResult() != 0) {
//            responseObserver.onError(Status.NOT_FOUND
//                    .withDescription("预览文件信息失败!")
//                    .asRuntimeException());
//            return;
//        }
//        FileUrlResponse fileUrlResponse
//                = FileUrlResponse.newBuilder().setObjEntity(filePreViewVOJsonObject.getObjEntity().getObjEntity()
//        ).setMesssage("success").setResult(0).build();
//        responseObserver.onNext(fileUrlResponse);
//        responseObserver.onCompleted();
//    }
//
//    /**
//     * 资料目录列表 (调用两个接口之后做数据拼接)
//     * @param request
//     * @param responseObserver
//     */
//    @Override
//    public void getTypeList(FileTypesRequest request, StreamObserver<FileTypesResponse> responseObserver) {
//        //获取到目录列表 List<FileTypeVO>
//        String typeId = request.getTypeId();
//        List<FileTypeVO> fileTypeVOList = new ArrayList<>();
//        PageVO<FileVO> fileVOPageVO = new PageVO<>();
//        if(!"0".equals(typeId)) {
//            //获取到分类列表
//            fileTypeVOList = fileManageFeginService.getTypeList(request.getTypeId()).getObjEntity();
//            //获取到文件列表
//            fileVOPageVO = fileManageFeginService.getFileList(new FileInfoQueryDTO(
//                    request.getCurrPage(),
//                    request.getPageSize(),
//                    request.getTypeId()
//                    )
//            ).getObjEntity();
//        }else{
//            //如果typeId 为 "0" 表示为首页 只获取到分类列表
//            fileTypeVOList = fileManageFeginService.getTypeList(request.getTypeId()).getObjEntity();
//        }
//        FileTypeVOS fileTypeVOS = new FileTypeVOS(fileTypeVOList,fileVOPageVO);
//        JsonObject<FileTypeVOS> result = new JsonObject<>(0,"query success",fileTypeVOS);
//        //将result存入response
//        List<FileTypes> fileTypesList = new ArrayList<>();
//        fileTypeVOList.stream().forEach(dto->
//                fileTypesList.add (FileTypes.newBuilder().setTypeId(dto.getTypeId()).setTypeName(dto.getTypeName()).build())
//        );
//        List<FileInfo> fileInfos = new ArrayList<>();
//        fileVOPageVO.getList().forEach(dto ->
//                fileInfos.add(
//                        FileInfo.newBuilder().setFid(dto.getDocId()).
//                                setName(dto.getDocName()).
//                                setSize(dto.getDocSize()).
//                                setCategory(dto.getDocCategory()).
//                                setType(dto.getDocType()).
//                                setWatchUrl(dto.getWatchUrl()).
//                                setShareNumber(dto.getDocShareNumber()).
//                                setDownloadNumber(dto.getDocDownloadNumber()).
//                                setCreatedId(dto.getCreatedById()).
//                                setCreatedName(dto.getCreatedByName()).
//                                setUpdatedId(dto.getUpdatedById()).
//                                setUpdatedName(dto.getUpdatedByName()).
//                                setUtime(simpleDateFormat.format(dto.getUpdatedTime())).
//                                setVersion(dto.getDocVersion())
//                                .build()
//                )
//        );
//        Integer currPage = fileVOPageVO.getCurrPage();
//        Integer totalCount = fileVOPageVO.getTotalCount();
//        Integer pageSize = fileVOPageVO.getPageSize();
//        int totalPage = (int) Math.ceil((double) totalCount / pageSize);
//        FileInfoEntity fileInfoEntity = FileInfoEntity.newBuilder().addAllList(fileInfos).setCurrPage(currPage).setPageSize(pageSize).setTotalCount(totalCount).setTotalPage(totalPage).build();
//        //
//        FileTypesObj fileTypesObj = FileTypesObj.newBuilder().addAllTypes(fileTypesList).setFiles(fileInfoEntity).build();
//        FileTypesResponse fileUrlResponse = FileTypesResponse.newBuilder().setObjEntity(fileTypesObj).setResult(0).setMesssage("query success").build();
//        responseObserver.onNext(fileUrlResponse);
//        responseObserver.onCompleted();
//    }
//}
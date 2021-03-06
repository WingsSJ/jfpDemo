// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: fileManage.proto

package com.topsec.mobiapi.proto;

public interface FileQueryRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:com.topsec.mobiapi.proto.FileQueryRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string searchCondition = 1;</code>
   */
  java.lang.String getSearchCondition();
  /**
   * <code>string searchCondition = 1;</code>
   */
  com.google.protobuf.ByteString
      getSearchConditionBytes();

  /**
   * <pre>
   *时间  0 一周内 1 一个月内 2 半年内
   * </pre>
   *
   * <code>int32 times = 2;</code>
   */
  int getTimes();

  /**
   * <pre>
   *每页数据量大小
   * </pre>
   *
   * <code>int32 pageSize = 3;</code>
   */
  int getPageSize();

  /**
   * <pre>
   *当前页码
   * </pre>
   *
   * <code>int32 currPage = 4;</code>
   */
  int getCurrPage();
}

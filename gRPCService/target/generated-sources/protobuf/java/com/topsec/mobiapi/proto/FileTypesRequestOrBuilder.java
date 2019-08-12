// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: fileManage.proto

package com.topsec.mobiapi.proto;

public interface FileTypesRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:com.topsec.mobiapi.proto.FileTypesRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   *文件分类ID(目录ID)
   * </pre>
   *
   * <code>string typeId = 1;</code>
   */
  java.lang.String getTypeId();
  /**
   * <pre>
   *文件分类ID(目录ID)
   * </pre>
   *
   * <code>string typeId = 1;</code>
   */
  com.google.protobuf.ByteString
      getTypeIdBytes();

  /**
   * <pre>
   *每页数据量大小
   * </pre>
   *
   * <code>int32 pageSize = 2;</code>
   */
  int getPageSize();

  /**
   * <pre>
   *当前页码
   * </pre>
   *
   * <code>int32 currPage = 3;</code>
   */
  int getCurrPage();
}

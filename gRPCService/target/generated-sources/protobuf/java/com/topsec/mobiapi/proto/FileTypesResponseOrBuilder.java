// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: fileManage.proto

package com.topsec.mobiapi.proto;

public interface FileTypesResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:com.topsec.mobiapi.proto.FileTypesResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   *结果 0 成功，1 失败
   * </pre>
   *
   * <code>int32 result = 1;</code>
   */
  int getResult();

  /**
   * <pre>
   *说明（成功）    “结果”
   * </pre>
   *
   * <code>string messsage = 2;</code>
   */
  java.lang.String getMesssage();
  /**
   * <pre>
   *说明（成功）    “结果”
   * </pre>
   *
   * <code>string messsage = 2;</code>
   */
  com.google.protobuf.ByteString
      getMesssageBytes();

  /**
   * <pre>
   *文件预览地址
   * </pre>
   *
   * <code>.com.topsec.mobiapi.proto.FileTypesObj objEntity = 3;</code>
   */
  boolean hasObjEntity();
  /**
   * <pre>
   *文件预览地址
   * </pre>
   *
   * <code>.com.topsec.mobiapi.proto.FileTypesObj objEntity = 3;</code>
   */
  com.topsec.mobiapi.proto.FileTypesObj getObjEntity();
  /**
   * <pre>
   *文件预览地址
   * </pre>
   *
   * <code>.com.topsec.mobiapi.proto.FileTypesObj objEntity = 3;</code>
   */
  com.topsec.mobiapi.proto.FileTypesObjOrBuilder getObjEntityOrBuilder();
}

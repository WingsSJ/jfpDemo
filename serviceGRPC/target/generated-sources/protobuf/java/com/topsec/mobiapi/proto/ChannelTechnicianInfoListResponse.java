// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: channel.proto

package com.topsec.mobiapi.proto;

/**
 * Protobuf type {@code com.topsec.mobiapi.proto.ChannelTechnicianInfoListResponse}
 */
public  final class ChannelTechnicianInfoListResponse extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:com.topsec.mobiapi.proto.ChannelTechnicianInfoListResponse)
    ChannelTechnicianInfoListResponseOrBuilder {
private static final long serialVersionUID = 0L;
  // Use ChannelTechnicianInfoListResponse.newBuilder() to construct.
  private ChannelTechnicianInfoListResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private ChannelTechnicianInfoListResponse() {
    result_ = 0;
    messsage_ = "";
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private ChannelTechnicianInfoListResponse(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          default: {
            if (!parseUnknownFieldProto3(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
          case 8: {

            result_ = input.readInt32();
            break;
          }
          case 18: {
            java.lang.String s = input.readStringRequireUtf8();

            messsage_ = s;
            break;
          }
          case 26: {
            com.topsec.mobiapi.proto.ChannelTechnicianEntity.Builder subBuilder = null;
            if (objEntity_ != null) {
              subBuilder = objEntity_.toBuilder();
            }
            objEntity_ = input.readMessage(com.topsec.mobiapi.proto.ChannelTechnicianEntity.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(objEntity_);
              objEntity_ = subBuilder.buildPartial();
            }

            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.topsec.mobiapi.proto.Channel.internal_static_com_topsec_mobiapi_proto_ChannelTechnicianInfoListResponse_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.topsec.mobiapi.proto.Channel.internal_static_com_topsec_mobiapi_proto_ChannelTechnicianInfoListResponse_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.topsec.mobiapi.proto.ChannelTechnicianInfoListResponse.class, com.topsec.mobiapi.proto.ChannelTechnicianInfoListResponse.Builder.class);
  }

  public static final int RESULT_FIELD_NUMBER = 1;
  private int result_;
  /**
   * <pre>
   *结果 0 成功，1 失败
   * </pre>
   *
   * <code>int32 result = 1;</code>
   */
  public int getResult() {
    return result_;
  }

  public static final int MESSSAGE_FIELD_NUMBER = 2;
  private volatile java.lang.Object messsage_;
  /**
   * <pre>
   *说明（成功）    “结果”
   * </pre>
   *
   * <code>string messsage = 2;</code>
   */
  public java.lang.String getMesssage() {
    java.lang.Object ref = messsage_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      messsage_ = s;
      return s;
    }
  }
  /**
   * <pre>
   *说明（成功）    “结果”
   * </pre>
   *
   * <code>string messsage = 2;</code>
   */
  public com.google.protobuf.ByteString
      getMesssageBytes() {
    java.lang.Object ref = messsage_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      messsage_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int OBJENTITY_FIELD_NUMBER = 3;
  private com.topsec.mobiapi.proto.ChannelTechnicianEntity objEntity_;
  /**
   * <pre>
   *返回的对象
   * </pre>
   *
   * <code>.com.topsec.mobiapi.proto.ChannelTechnicianEntity objEntity = 3;</code>
   */
  public boolean hasObjEntity() {
    return objEntity_ != null;
  }
  /**
   * <pre>
   *返回的对象
   * </pre>
   *
   * <code>.com.topsec.mobiapi.proto.ChannelTechnicianEntity objEntity = 3;</code>
   */
  public com.topsec.mobiapi.proto.ChannelTechnicianEntity getObjEntity() {
    return objEntity_ == null ? com.topsec.mobiapi.proto.ChannelTechnicianEntity.getDefaultInstance() : objEntity_;
  }
  /**
   * <pre>
   *返回的对象
   * </pre>
   *
   * <code>.com.topsec.mobiapi.proto.ChannelTechnicianEntity objEntity = 3;</code>
   */
  public com.topsec.mobiapi.proto.ChannelTechnicianEntityOrBuilder getObjEntityOrBuilder() {
    return getObjEntity();
  }

  private byte memoizedIsInitialized = -1;
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (result_ != 0) {
      output.writeInt32(1, result_);
    }
    if (!getMesssageBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, messsage_);
    }
    if (objEntity_ != null) {
      output.writeMessage(3, getObjEntity());
    }
    unknownFields.writeTo(output);
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (result_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(1, result_);
    }
    if (!getMesssageBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, messsage_);
    }
    if (objEntity_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(3, getObjEntity());
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof com.topsec.mobiapi.proto.ChannelTechnicianInfoListResponse)) {
      return super.equals(obj);
    }
    com.topsec.mobiapi.proto.ChannelTechnicianInfoListResponse other = (com.topsec.mobiapi.proto.ChannelTechnicianInfoListResponse) obj;

    boolean result = true;
    result = result && (getResult()
        == other.getResult());
    result = result && getMesssage()
        .equals(other.getMesssage());
    result = result && (hasObjEntity() == other.hasObjEntity());
    if (hasObjEntity()) {
      result = result && getObjEntity()
          .equals(other.getObjEntity());
    }
    result = result && unknownFields.equals(other.unknownFields);
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + RESULT_FIELD_NUMBER;
    hash = (53 * hash) + getResult();
    hash = (37 * hash) + MESSSAGE_FIELD_NUMBER;
    hash = (53 * hash) + getMesssage().hashCode();
    if (hasObjEntity()) {
      hash = (37 * hash) + OBJENTITY_FIELD_NUMBER;
      hash = (53 * hash) + getObjEntity().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.topsec.mobiapi.proto.ChannelTechnicianInfoListResponse parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.topsec.mobiapi.proto.ChannelTechnicianInfoListResponse parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.topsec.mobiapi.proto.ChannelTechnicianInfoListResponse parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.topsec.mobiapi.proto.ChannelTechnicianInfoListResponse parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.topsec.mobiapi.proto.ChannelTechnicianInfoListResponse parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.topsec.mobiapi.proto.ChannelTechnicianInfoListResponse parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.topsec.mobiapi.proto.ChannelTechnicianInfoListResponse parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.topsec.mobiapi.proto.ChannelTechnicianInfoListResponse parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.topsec.mobiapi.proto.ChannelTechnicianInfoListResponse parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.topsec.mobiapi.proto.ChannelTechnicianInfoListResponse parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.topsec.mobiapi.proto.ChannelTechnicianInfoListResponse parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.topsec.mobiapi.proto.ChannelTechnicianInfoListResponse parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(com.topsec.mobiapi.proto.ChannelTechnicianInfoListResponse prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code com.topsec.mobiapi.proto.ChannelTechnicianInfoListResponse}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:com.topsec.mobiapi.proto.ChannelTechnicianInfoListResponse)
      com.topsec.mobiapi.proto.ChannelTechnicianInfoListResponseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.topsec.mobiapi.proto.Channel.internal_static_com_topsec_mobiapi_proto_ChannelTechnicianInfoListResponse_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.topsec.mobiapi.proto.Channel.internal_static_com_topsec_mobiapi_proto_ChannelTechnicianInfoListResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.topsec.mobiapi.proto.ChannelTechnicianInfoListResponse.class, com.topsec.mobiapi.proto.ChannelTechnicianInfoListResponse.Builder.class);
    }

    // Construct using com.topsec.mobiapi.proto.ChannelTechnicianInfoListResponse.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    public Builder clear() {
      super.clear();
      result_ = 0;

      messsage_ = "";

      if (objEntityBuilder_ == null) {
        objEntity_ = null;
      } else {
        objEntity_ = null;
        objEntityBuilder_ = null;
      }
      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.topsec.mobiapi.proto.Channel.internal_static_com_topsec_mobiapi_proto_ChannelTechnicianInfoListResponse_descriptor;
    }

    public com.topsec.mobiapi.proto.ChannelTechnicianInfoListResponse getDefaultInstanceForType() {
      return com.topsec.mobiapi.proto.ChannelTechnicianInfoListResponse.getDefaultInstance();
    }

    public com.topsec.mobiapi.proto.ChannelTechnicianInfoListResponse build() {
      com.topsec.mobiapi.proto.ChannelTechnicianInfoListResponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public com.topsec.mobiapi.proto.ChannelTechnicianInfoListResponse buildPartial() {
      com.topsec.mobiapi.proto.ChannelTechnicianInfoListResponse result = new com.topsec.mobiapi.proto.ChannelTechnicianInfoListResponse(this);
      result.result_ = result_;
      result.messsage_ = messsage_;
      if (objEntityBuilder_ == null) {
        result.objEntity_ = objEntity_;
      } else {
        result.objEntity_ = objEntityBuilder_.build();
      }
      onBuilt();
      return result;
    }

    public Builder clone() {
      return (Builder) super.clone();
    }
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.setField(field, value);
    }
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.topsec.mobiapi.proto.ChannelTechnicianInfoListResponse) {
        return mergeFrom((com.topsec.mobiapi.proto.ChannelTechnicianInfoListResponse)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.topsec.mobiapi.proto.ChannelTechnicianInfoListResponse other) {
      if (other == com.topsec.mobiapi.proto.ChannelTechnicianInfoListResponse.getDefaultInstance()) return this;
      if (other.getResult() != 0) {
        setResult(other.getResult());
      }
      if (!other.getMesssage().isEmpty()) {
        messsage_ = other.messsage_;
        onChanged();
      }
      if (other.hasObjEntity()) {
        mergeObjEntity(other.getObjEntity());
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    public final boolean isInitialized() {
      return true;
    }

    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      com.topsec.mobiapi.proto.ChannelTechnicianInfoListResponse parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.topsec.mobiapi.proto.ChannelTechnicianInfoListResponse) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private int result_ ;
    /**
     * <pre>
     *结果 0 成功，1 失败
     * </pre>
     *
     * <code>int32 result = 1;</code>
     */
    public int getResult() {
      return result_;
    }
    /**
     * <pre>
     *结果 0 成功，1 失败
     * </pre>
     *
     * <code>int32 result = 1;</code>
     */
    public Builder setResult(int value) {
      
      result_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     *结果 0 成功，1 失败
     * </pre>
     *
     * <code>int32 result = 1;</code>
     */
    public Builder clearResult() {
      
      result_ = 0;
      onChanged();
      return this;
    }

    private java.lang.Object messsage_ = "";
    /**
     * <pre>
     *说明（成功）    “结果”
     * </pre>
     *
     * <code>string messsage = 2;</code>
     */
    public java.lang.String getMesssage() {
      java.lang.Object ref = messsage_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        messsage_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <pre>
     *说明（成功）    “结果”
     * </pre>
     *
     * <code>string messsage = 2;</code>
     */
    public com.google.protobuf.ByteString
        getMesssageBytes() {
      java.lang.Object ref = messsage_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        messsage_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <pre>
     *说明（成功）    “结果”
     * </pre>
     *
     * <code>string messsage = 2;</code>
     */
    public Builder setMesssage(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      messsage_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     *说明（成功）    “结果”
     * </pre>
     *
     * <code>string messsage = 2;</code>
     */
    public Builder clearMesssage() {
      
      messsage_ = getDefaultInstance().getMesssage();
      onChanged();
      return this;
    }
    /**
     * <pre>
     *说明（成功）    “结果”
     * </pre>
     *
     * <code>string messsage = 2;</code>
     */
    public Builder setMesssageBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      messsage_ = value;
      onChanged();
      return this;
    }

    private com.topsec.mobiapi.proto.ChannelTechnicianEntity objEntity_ = null;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.topsec.mobiapi.proto.ChannelTechnicianEntity, com.topsec.mobiapi.proto.ChannelTechnicianEntity.Builder, com.topsec.mobiapi.proto.ChannelTechnicianEntityOrBuilder> objEntityBuilder_;
    /**
     * <pre>
     *返回的对象
     * </pre>
     *
     * <code>.com.topsec.mobiapi.proto.ChannelTechnicianEntity objEntity = 3;</code>
     */
    public boolean hasObjEntity() {
      return objEntityBuilder_ != null || objEntity_ != null;
    }
    /**
     * <pre>
     *返回的对象
     * </pre>
     *
     * <code>.com.topsec.mobiapi.proto.ChannelTechnicianEntity objEntity = 3;</code>
     */
    public com.topsec.mobiapi.proto.ChannelTechnicianEntity getObjEntity() {
      if (objEntityBuilder_ == null) {
        return objEntity_ == null ? com.topsec.mobiapi.proto.ChannelTechnicianEntity.getDefaultInstance() : objEntity_;
      } else {
        return objEntityBuilder_.getMessage();
      }
    }
    /**
     * <pre>
     *返回的对象
     * </pre>
     *
     * <code>.com.topsec.mobiapi.proto.ChannelTechnicianEntity objEntity = 3;</code>
     */
    public Builder setObjEntity(com.topsec.mobiapi.proto.ChannelTechnicianEntity value) {
      if (objEntityBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        objEntity_ = value;
        onChanged();
      } else {
        objEntityBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <pre>
     *返回的对象
     * </pre>
     *
     * <code>.com.topsec.mobiapi.proto.ChannelTechnicianEntity objEntity = 3;</code>
     */
    public Builder setObjEntity(
        com.topsec.mobiapi.proto.ChannelTechnicianEntity.Builder builderForValue) {
      if (objEntityBuilder_ == null) {
        objEntity_ = builderForValue.build();
        onChanged();
      } else {
        objEntityBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <pre>
     *返回的对象
     * </pre>
     *
     * <code>.com.topsec.mobiapi.proto.ChannelTechnicianEntity objEntity = 3;</code>
     */
    public Builder mergeObjEntity(com.topsec.mobiapi.proto.ChannelTechnicianEntity value) {
      if (objEntityBuilder_ == null) {
        if (objEntity_ != null) {
          objEntity_ =
            com.topsec.mobiapi.proto.ChannelTechnicianEntity.newBuilder(objEntity_).mergeFrom(value).buildPartial();
        } else {
          objEntity_ = value;
        }
        onChanged();
      } else {
        objEntityBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <pre>
     *返回的对象
     * </pre>
     *
     * <code>.com.topsec.mobiapi.proto.ChannelTechnicianEntity objEntity = 3;</code>
     */
    public Builder clearObjEntity() {
      if (objEntityBuilder_ == null) {
        objEntity_ = null;
        onChanged();
      } else {
        objEntity_ = null;
        objEntityBuilder_ = null;
      }

      return this;
    }
    /**
     * <pre>
     *返回的对象
     * </pre>
     *
     * <code>.com.topsec.mobiapi.proto.ChannelTechnicianEntity objEntity = 3;</code>
     */
    public com.topsec.mobiapi.proto.ChannelTechnicianEntity.Builder getObjEntityBuilder() {
      
      onChanged();
      return getObjEntityFieldBuilder().getBuilder();
    }
    /**
     * <pre>
     *返回的对象
     * </pre>
     *
     * <code>.com.topsec.mobiapi.proto.ChannelTechnicianEntity objEntity = 3;</code>
     */
    public com.topsec.mobiapi.proto.ChannelTechnicianEntityOrBuilder getObjEntityOrBuilder() {
      if (objEntityBuilder_ != null) {
        return objEntityBuilder_.getMessageOrBuilder();
      } else {
        return objEntity_ == null ?
            com.topsec.mobiapi.proto.ChannelTechnicianEntity.getDefaultInstance() : objEntity_;
      }
    }
    /**
     * <pre>
     *返回的对象
     * </pre>
     *
     * <code>.com.topsec.mobiapi.proto.ChannelTechnicianEntity objEntity = 3;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.topsec.mobiapi.proto.ChannelTechnicianEntity, com.topsec.mobiapi.proto.ChannelTechnicianEntity.Builder, com.topsec.mobiapi.proto.ChannelTechnicianEntityOrBuilder> 
        getObjEntityFieldBuilder() {
      if (objEntityBuilder_ == null) {
        objEntityBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.topsec.mobiapi.proto.ChannelTechnicianEntity, com.topsec.mobiapi.proto.ChannelTechnicianEntity.Builder, com.topsec.mobiapi.proto.ChannelTechnicianEntityOrBuilder>(
                getObjEntity(),
                getParentForChildren(),
                isClean());
        objEntity_ = null;
      }
      return objEntityBuilder_;
    }
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFieldsProto3(unknownFields);
    }

    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:com.topsec.mobiapi.proto.ChannelTechnicianInfoListResponse)
  }

  // @@protoc_insertion_point(class_scope:com.topsec.mobiapi.proto.ChannelTechnicianInfoListResponse)
  private static final com.topsec.mobiapi.proto.ChannelTechnicianInfoListResponse DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.topsec.mobiapi.proto.ChannelTechnicianInfoListResponse();
  }

  public static com.topsec.mobiapi.proto.ChannelTechnicianInfoListResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<ChannelTechnicianInfoListResponse>
      PARSER = new com.google.protobuf.AbstractParser<ChannelTechnicianInfoListResponse>() {
    public ChannelTechnicianInfoListResponse parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new ChannelTechnicianInfoListResponse(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<ChannelTechnicianInfoListResponse> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<ChannelTechnicianInfoListResponse> getParserForType() {
    return PARSER;
  }

  public com.topsec.mobiapi.proto.ChannelTechnicianInfoListResponse getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}


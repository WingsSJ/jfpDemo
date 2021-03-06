// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: channel.proto

package com.topsec.mobiapi.proto;

/**
 * <pre>
 * 渠道商条件查询条件
 * </pre>
 *
 * Protobuf type {@code com.topsec.mobiapi.proto.ChannelCompanyInfoRequest}
 */
public  final class ChannelCompanyInfoRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:com.topsec.mobiapi.proto.ChannelCompanyInfoRequest)
    ChannelCompanyInfoRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use ChannelCompanyInfoRequest.newBuilder() to construct.
  private ChannelCompanyInfoRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private ChannelCompanyInfoRequest() {
    starLevel_ = 0;
    province_ = "";
    searchCondition_ = "";
    pageSize_ = 0;
    currPage_ = 0;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private ChannelCompanyInfoRequest(
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

            starLevel_ = input.readInt32();
            break;
          }
          case 18: {
            java.lang.String s = input.readStringRequireUtf8();

            province_ = s;
            break;
          }
          case 26: {
            java.lang.String s = input.readStringRequireUtf8();

            searchCondition_ = s;
            break;
          }
          case 32: {

            pageSize_ = input.readInt32();
            break;
          }
          case 40: {

            currPage_ = input.readInt32();
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
    return com.topsec.mobiapi.proto.Channel.internal_static_com_topsec_mobiapi_proto_ChannelCompanyInfoRequest_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.topsec.mobiapi.proto.Channel.internal_static_com_topsec_mobiapi_proto_ChannelCompanyInfoRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.topsec.mobiapi.proto.ChannelCompanyInfoRequest.class, com.topsec.mobiapi.proto.ChannelCompanyInfoRequest.Builder.class);
  }

  public static final int STARLEVEL_FIELD_NUMBER = 1;
  private int starLevel_;
  /**
   * <pre>
   *服务商星级
   * </pre>
   *
   * <code>int32 starLevel = 1;</code>
   */
  public int getStarLevel() {
    return starLevel_;
  }

  public static final int PROVINCE_FIELD_NUMBER = 2;
  private volatile java.lang.Object province_;
  /**
   * <pre>
   *服务商所在省份
   * </pre>
   *
   * <code>string province = 2;</code>
   */
  public java.lang.String getProvince() {
    java.lang.Object ref = province_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      province_ = s;
      return s;
    }
  }
  /**
   * <pre>
   *服务商所在省份
   * </pre>
   *
   * <code>string province = 2;</code>
   */
  public com.google.protobuf.ByteString
      getProvinceBytes() {
    java.lang.Object ref = province_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      province_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int SEARCHCONDITION_FIELD_NUMBER = 3;
  private volatile java.lang.Object searchCondition_;
  /**
   * <pre>
   *模糊查询条件
   * </pre>
   *
   * <code>string searchCondition = 3;</code>
   */
  public java.lang.String getSearchCondition() {
    java.lang.Object ref = searchCondition_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      searchCondition_ = s;
      return s;
    }
  }
  /**
   * <pre>
   *模糊查询条件
   * </pre>
   *
   * <code>string searchCondition = 3;</code>
   */
  public com.google.protobuf.ByteString
      getSearchConditionBytes() {
    java.lang.Object ref = searchCondition_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      searchCondition_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int PAGESIZE_FIELD_NUMBER = 4;
  private int pageSize_;
  /**
   * <pre>
   *每页数据量大小
   * </pre>
   *
   * <code>int32 pageSize = 4;</code>
   */
  public int getPageSize() {
    return pageSize_;
  }

  public static final int CURRPAGE_FIELD_NUMBER = 5;
  private int currPage_;
  /**
   * <pre>
   *当前页码
   * </pre>
   *
   * <code>int32 currPage = 5;</code>
   */
  public int getCurrPage() {
    return currPage_;
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
    if (starLevel_ != 0) {
      output.writeInt32(1, starLevel_);
    }
    if (!getProvinceBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, province_);
    }
    if (!getSearchConditionBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 3, searchCondition_);
    }
    if (pageSize_ != 0) {
      output.writeInt32(4, pageSize_);
    }
    if (currPage_ != 0) {
      output.writeInt32(5, currPage_);
    }
    unknownFields.writeTo(output);
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (starLevel_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(1, starLevel_);
    }
    if (!getProvinceBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, province_);
    }
    if (!getSearchConditionBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, searchCondition_);
    }
    if (pageSize_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(4, pageSize_);
    }
    if (currPage_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(5, currPage_);
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
    if (!(obj instanceof com.topsec.mobiapi.proto.ChannelCompanyInfoRequest)) {
      return super.equals(obj);
    }
    com.topsec.mobiapi.proto.ChannelCompanyInfoRequest other = (com.topsec.mobiapi.proto.ChannelCompanyInfoRequest) obj;

    boolean result = true;
    result = result && (getStarLevel()
        == other.getStarLevel());
    result = result && getProvince()
        .equals(other.getProvince());
    result = result && getSearchCondition()
        .equals(other.getSearchCondition());
    result = result && (getPageSize()
        == other.getPageSize());
    result = result && (getCurrPage()
        == other.getCurrPage());
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
    hash = (37 * hash) + STARLEVEL_FIELD_NUMBER;
    hash = (53 * hash) + getStarLevel();
    hash = (37 * hash) + PROVINCE_FIELD_NUMBER;
    hash = (53 * hash) + getProvince().hashCode();
    hash = (37 * hash) + SEARCHCONDITION_FIELD_NUMBER;
    hash = (53 * hash) + getSearchCondition().hashCode();
    hash = (37 * hash) + PAGESIZE_FIELD_NUMBER;
    hash = (53 * hash) + getPageSize();
    hash = (37 * hash) + CURRPAGE_FIELD_NUMBER;
    hash = (53 * hash) + getCurrPage();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.topsec.mobiapi.proto.ChannelCompanyInfoRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.topsec.mobiapi.proto.ChannelCompanyInfoRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.topsec.mobiapi.proto.ChannelCompanyInfoRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.topsec.mobiapi.proto.ChannelCompanyInfoRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.topsec.mobiapi.proto.ChannelCompanyInfoRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.topsec.mobiapi.proto.ChannelCompanyInfoRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.topsec.mobiapi.proto.ChannelCompanyInfoRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.topsec.mobiapi.proto.ChannelCompanyInfoRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.topsec.mobiapi.proto.ChannelCompanyInfoRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.topsec.mobiapi.proto.ChannelCompanyInfoRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.topsec.mobiapi.proto.ChannelCompanyInfoRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.topsec.mobiapi.proto.ChannelCompanyInfoRequest parseFrom(
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
  public static Builder newBuilder(com.topsec.mobiapi.proto.ChannelCompanyInfoRequest prototype) {
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
   * <pre>
   * 渠道商条件查询条件
   * </pre>
   *
   * Protobuf type {@code com.topsec.mobiapi.proto.ChannelCompanyInfoRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:com.topsec.mobiapi.proto.ChannelCompanyInfoRequest)
      com.topsec.mobiapi.proto.ChannelCompanyInfoRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.topsec.mobiapi.proto.Channel.internal_static_com_topsec_mobiapi_proto_ChannelCompanyInfoRequest_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.topsec.mobiapi.proto.Channel.internal_static_com_topsec_mobiapi_proto_ChannelCompanyInfoRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.topsec.mobiapi.proto.ChannelCompanyInfoRequest.class, com.topsec.mobiapi.proto.ChannelCompanyInfoRequest.Builder.class);
    }

    // Construct using com.topsec.mobiapi.proto.ChannelCompanyInfoRequest.newBuilder()
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
      starLevel_ = 0;

      province_ = "";

      searchCondition_ = "";

      pageSize_ = 0;

      currPage_ = 0;

      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.topsec.mobiapi.proto.Channel.internal_static_com_topsec_mobiapi_proto_ChannelCompanyInfoRequest_descriptor;
    }

    public com.topsec.mobiapi.proto.ChannelCompanyInfoRequest getDefaultInstanceForType() {
      return com.topsec.mobiapi.proto.ChannelCompanyInfoRequest.getDefaultInstance();
    }

    public com.topsec.mobiapi.proto.ChannelCompanyInfoRequest build() {
      com.topsec.mobiapi.proto.ChannelCompanyInfoRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public com.topsec.mobiapi.proto.ChannelCompanyInfoRequest buildPartial() {
      com.topsec.mobiapi.proto.ChannelCompanyInfoRequest result = new com.topsec.mobiapi.proto.ChannelCompanyInfoRequest(this);
      result.starLevel_ = starLevel_;
      result.province_ = province_;
      result.searchCondition_ = searchCondition_;
      result.pageSize_ = pageSize_;
      result.currPage_ = currPage_;
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
      if (other instanceof com.topsec.mobiapi.proto.ChannelCompanyInfoRequest) {
        return mergeFrom((com.topsec.mobiapi.proto.ChannelCompanyInfoRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.topsec.mobiapi.proto.ChannelCompanyInfoRequest other) {
      if (other == com.topsec.mobiapi.proto.ChannelCompanyInfoRequest.getDefaultInstance()) return this;
      if (other.getStarLevel() != 0) {
        setStarLevel(other.getStarLevel());
      }
      if (!other.getProvince().isEmpty()) {
        province_ = other.province_;
        onChanged();
      }
      if (!other.getSearchCondition().isEmpty()) {
        searchCondition_ = other.searchCondition_;
        onChanged();
      }
      if (other.getPageSize() != 0) {
        setPageSize(other.getPageSize());
      }
      if (other.getCurrPage() != 0) {
        setCurrPage(other.getCurrPage());
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
      com.topsec.mobiapi.proto.ChannelCompanyInfoRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.topsec.mobiapi.proto.ChannelCompanyInfoRequest) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private int starLevel_ ;
    /**
     * <pre>
     *服务商星级
     * </pre>
     *
     * <code>int32 starLevel = 1;</code>
     */
    public int getStarLevel() {
      return starLevel_;
    }
    /**
     * <pre>
     *服务商星级
     * </pre>
     *
     * <code>int32 starLevel = 1;</code>
     */
    public Builder setStarLevel(int value) {
      
      starLevel_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     *服务商星级
     * </pre>
     *
     * <code>int32 starLevel = 1;</code>
     */
    public Builder clearStarLevel() {
      
      starLevel_ = 0;
      onChanged();
      return this;
    }

    private java.lang.Object province_ = "";
    /**
     * <pre>
     *服务商所在省份
     * </pre>
     *
     * <code>string province = 2;</code>
     */
    public java.lang.String getProvince() {
      java.lang.Object ref = province_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        province_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <pre>
     *服务商所在省份
     * </pre>
     *
     * <code>string province = 2;</code>
     */
    public com.google.protobuf.ByteString
        getProvinceBytes() {
      java.lang.Object ref = province_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        province_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <pre>
     *服务商所在省份
     * </pre>
     *
     * <code>string province = 2;</code>
     */
    public Builder setProvince(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      province_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     *服务商所在省份
     * </pre>
     *
     * <code>string province = 2;</code>
     */
    public Builder clearProvince() {
      
      province_ = getDefaultInstance().getProvince();
      onChanged();
      return this;
    }
    /**
     * <pre>
     *服务商所在省份
     * </pre>
     *
     * <code>string province = 2;</code>
     */
    public Builder setProvinceBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      province_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object searchCondition_ = "";
    /**
     * <pre>
     *模糊查询条件
     * </pre>
     *
     * <code>string searchCondition = 3;</code>
     */
    public java.lang.String getSearchCondition() {
      java.lang.Object ref = searchCondition_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        searchCondition_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <pre>
     *模糊查询条件
     * </pre>
     *
     * <code>string searchCondition = 3;</code>
     */
    public com.google.protobuf.ByteString
        getSearchConditionBytes() {
      java.lang.Object ref = searchCondition_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        searchCondition_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <pre>
     *模糊查询条件
     * </pre>
     *
     * <code>string searchCondition = 3;</code>
     */
    public Builder setSearchCondition(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      searchCondition_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     *模糊查询条件
     * </pre>
     *
     * <code>string searchCondition = 3;</code>
     */
    public Builder clearSearchCondition() {
      
      searchCondition_ = getDefaultInstance().getSearchCondition();
      onChanged();
      return this;
    }
    /**
     * <pre>
     *模糊查询条件
     * </pre>
     *
     * <code>string searchCondition = 3;</code>
     */
    public Builder setSearchConditionBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      searchCondition_ = value;
      onChanged();
      return this;
    }

    private int pageSize_ ;
    /**
     * <pre>
     *每页数据量大小
     * </pre>
     *
     * <code>int32 pageSize = 4;</code>
     */
    public int getPageSize() {
      return pageSize_;
    }
    /**
     * <pre>
     *每页数据量大小
     * </pre>
     *
     * <code>int32 pageSize = 4;</code>
     */
    public Builder setPageSize(int value) {
      
      pageSize_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     *每页数据量大小
     * </pre>
     *
     * <code>int32 pageSize = 4;</code>
     */
    public Builder clearPageSize() {
      
      pageSize_ = 0;
      onChanged();
      return this;
    }

    private int currPage_ ;
    /**
     * <pre>
     *当前页码
     * </pre>
     *
     * <code>int32 currPage = 5;</code>
     */
    public int getCurrPage() {
      return currPage_;
    }
    /**
     * <pre>
     *当前页码
     * </pre>
     *
     * <code>int32 currPage = 5;</code>
     */
    public Builder setCurrPage(int value) {
      
      currPage_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     *当前页码
     * </pre>
     *
     * <code>int32 currPage = 5;</code>
     */
    public Builder clearCurrPage() {
      
      currPage_ = 0;
      onChanged();
      return this;
    }
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFieldsProto3(unknownFields);
    }

    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:com.topsec.mobiapi.proto.ChannelCompanyInfoRequest)
  }

  // @@protoc_insertion_point(class_scope:com.topsec.mobiapi.proto.ChannelCompanyInfoRequest)
  private static final com.topsec.mobiapi.proto.ChannelCompanyInfoRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.topsec.mobiapi.proto.ChannelCompanyInfoRequest();
  }

  public static com.topsec.mobiapi.proto.ChannelCompanyInfoRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<ChannelCompanyInfoRequest>
      PARSER = new com.google.protobuf.AbstractParser<ChannelCompanyInfoRequest>() {
    public ChannelCompanyInfoRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new ChannelCompanyInfoRequest(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<ChannelCompanyInfoRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<ChannelCompanyInfoRequest> getParserForType() {
    return PARSER;
  }

  public com.topsec.mobiapi.proto.ChannelCompanyInfoRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}


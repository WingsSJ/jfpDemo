// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: channel.proto

package com.topsec.mobiapi.proto;

/**
 * Protobuf type {@code com.topsec.mobiapi.proto.ChannelTechnicianEntity}
 */
public  final class ChannelTechnicianEntity extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:com.topsec.mobiapi.proto.ChannelTechnicianEntity)
    ChannelTechnicianEntityOrBuilder {
private static final long serialVersionUID = 0L;
  // Use ChannelTechnicianEntity.newBuilder() to construct.
  private ChannelTechnicianEntity(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private ChannelTechnicianEntity() {
    pageSize_ = 0;
    currPage_ = 0;
    totalCount_ = 0;
    totalPage_ = 0;
    list_ = java.util.Collections.emptyList();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private ChannelTechnicianEntity(
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

            pageSize_ = input.readInt32();
            break;
          }
          case 16: {

            currPage_ = input.readInt32();
            break;
          }
          case 24: {

            totalCount_ = input.readInt32();
            break;
          }
          case 32: {

            totalPage_ = input.readInt32();
            break;
          }
          case 42: {
            if (!((mutable_bitField0_ & 0x00000010) == 0x00000010)) {
              list_ = new java.util.ArrayList<com.topsec.mobiapi.proto.ChannelTechnicianInfo>();
              mutable_bitField0_ |= 0x00000010;
            }
            list_.add(
                input.readMessage(com.topsec.mobiapi.proto.ChannelTechnicianInfo.parser(), extensionRegistry));
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
      if (((mutable_bitField0_ & 0x00000010) == 0x00000010)) {
        list_ = java.util.Collections.unmodifiableList(list_);
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.topsec.mobiapi.proto.Channel.internal_static_com_topsec_mobiapi_proto_ChannelTechnicianEntity_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.topsec.mobiapi.proto.Channel.internal_static_com_topsec_mobiapi_proto_ChannelTechnicianEntity_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.topsec.mobiapi.proto.ChannelTechnicianEntity.class, com.topsec.mobiapi.proto.ChannelTechnicianEntity.Builder.class);
  }

  private int bitField0_;
  public static final int PAGESIZE_FIELD_NUMBER = 1;
  private int pageSize_;
  /**
   * <pre>
   *每页数据量大小
   * </pre>
   *
   * <code>int32 pageSize = 1;</code>
   */
  public int getPageSize() {
    return pageSize_;
  }

  public static final int CURRPAGE_FIELD_NUMBER = 2;
  private int currPage_;
  /**
   * <pre>
   *当前页码
   * </pre>
   *
   * <code>int32 currPage = 2;</code>
   */
  public int getCurrPage() {
    return currPage_;
  }

  public static final int TOTALCOUNT_FIELD_NUMBER = 3;
  private int totalCount_;
  /**
   * <pre>
   *总记录数
   * </pre>
   *
   * <code>int32 totalCount = 3;</code>
   */
  public int getTotalCount() {
    return totalCount_;
  }

  public static final int TOTALPAGE_FIELD_NUMBER = 4;
  private int totalPage_;
  /**
   * <pre>
   *总页数
   * </pre>
   *
   * <code>int32 totalPage = 4;</code>
   */
  public int getTotalPage() {
    return totalPage_;
  }

  public static final int LIST_FIELD_NUMBER = 5;
  private java.util.List<com.topsec.mobiapi.proto.ChannelTechnicianInfo> list_;
  /**
   * <pre>
   *人员信息 + 证书信息
   * </pre>
   *
   * <code>repeated .com.topsec.mobiapi.proto.ChannelTechnicianInfo list = 5;</code>
   */
  public java.util.List<com.topsec.mobiapi.proto.ChannelTechnicianInfo> getListList() {
    return list_;
  }
  /**
   * <pre>
   *人员信息 + 证书信息
   * </pre>
   *
   * <code>repeated .com.topsec.mobiapi.proto.ChannelTechnicianInfo list = 5;</code>
   */
  public java.util.List<? extends com.topsec.mobiapi.proto.ChannelTechnicianInfoOrBuilder> 
      getListOrBuilderList() {
    return list_;
  }
  /**
   * <pre>
   *人员信息 + 证书信息
   * </pre>
   *
   * <code>repeated .com.topsec.mobiapi.proto.ChannelTechnicianInfo list = 5;</code>
   */
  public int getListCount() {
    return list_.size();
  }
  /**
   * <pre>
   *人员信息 + 证书信息
   * </pre>
   *
   * <code>repeated .com.topsec.mobiapi.proto.ChannelTechnicianInfo list = 5;</code>
   */
  public com.topsec.mobiapi.proto.ChannelTechnicianInfo getList(int index) {
    return list_.get(index);
  }
  /**
   * <pre>
   *人员信息 + 证书信息
   * </pre>
   *
   * <code>repeated .com.topsec.mobiapi.proto.ChannelTechnicianInfo list = 5;</code>
   */
  public com.topsec.mobiapi.proto.ChannelTechnicianInfoOrBuilder getListOrBuilder(
      int index) {
    return list_.get(index);
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
    if (pageSize_ != 0) {
      output.writeInt32(1, pageSize_);
    }
    if (currPage_ != 0) {
      output.writeInt32(2, currPage_);
    }
    if (totalCount_ != 0) {
      output.writeInt32(3, totalCount_);
    }
    if (totalPage_ != 0) {
      output.writeInt32(4, totalPage_);
    }
    for (int i = 0; i < list_.size(); i++) {
      output.writeMessage(5, list_.get(i));
    }
    unknownFields.writeTo(output);
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (pageSize_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(1, pageSize_);
    }
    if (currPage_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(2, currPage_);
    }
    if (totalCount_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(3, totalCount_);
    }
    if (totalPage_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(4, totalPage_);
    }
    for (int i = 0; i < list_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(5, list_.get(i));
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
    if (!(obj instanceof com.topsec.mobiapi.proto.ChannelTechnicianEntity)) {
      return super.equals(obj);
    }
    com.topsec.mobiapi.proto.ChannelTechnicianEntity other = (com.topsec.mobiapi.proto.ChannelTechnicianEntity) obj;

    boolean result = true;
    result = result && (getPageSize()
        == other.getPageSize());
    result = result && (getCurrPage()
        == other.getCurrPage());
    result = result && (getTotalCount()
        == other.getTotalCount());
    result = result && (getTotalPage()
        == other.getTotalPage());
    result = result && getListList()
        .equals(other.getListList());
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
    hash = (37 * hash) + PAGESIZE_FIELD_NUMBER;
    hash = (53 * hash) + getPageSize();
    hash = (37 * hash) + CURRPAGE_FIELD_NUMBER;
    hash = (53 * hash) + getCurrPage();
    hash = (37 * hash) + TOTALCOUNT_FIELD_NUMBER;
    hash = (53 * hash) + getTotalCount();
    hash = (37 * hash) + TOTALPAGE_FIELD_NUMBER;
    hash = (53 * hash) + getTotalPage();
    if (getListCount() > 0) {
      hash = (37 * hash) + LIST_FIELD_NUMBER;
      hash = (53 * hash) + getListList().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.topsec.mobiapi.proto.ChannelTechnicianEntity parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.topsec.mobiapi.proto.ChannelTechnicianEntity parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.topsec.mobiapi.proto.ChannelTechnicianEntity parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.topsec.mobiapi.proto.ChannelTechnicianEntity parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.topsec.mobiapi.proto.ChannelTechnicianEntity parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.topsec.mobiapi.proto.ChannelTechnicianEntity parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.topsec.mobiapi.proto.ChannelTechnicianEntity parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.topsec.mobiapi.proto.ChannelTechnicianEntity parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.topsec.mobiapi.proto.ChannelTechnicianEntity parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.topsec.mobiapi.proto.ChannelTechnicianEntity parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.topsec.mobiapi.proto.ChannelTechnicianEntity parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.topsec.mobiapi.proto.ChannelTechnicianEntity parseFrom(
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
  public static Builder newBuilder(com.topsec.mobiapi.proto.ChannelTechnicianEntity prototype) {
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
   * Protobuf type {@code com.topsec.mobiapi.proto.ChannelTechnicianEntity}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:com.topsec.mobiapi.proto.ChannelTechnicianEntity)
      com.topsec.mobiapi.proto.ChannelTechnicianEntityOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.topsec.mobiapi.proto.Channel.internal_static_com_topsec_mobiapi_proto_ChannelTechnicianEntity_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.topsec.mobiapi.proto.Channel.internal_static_com_topsec_mobiapi_proto_ChannelTechnicianEntity_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.topsec.mobiapi.proto.ChannelTechnicianEntity.class, com.topsec.mobiapi.proto.ChannelTechnicianEntity.Builder.class);
    }

    // Construct using com.topsec.mobiapi.proto.ChannelTechnicianEntity.newBuilder()
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
        getListFieldBuilder();
      }
    }
    public Builder clear() {
      super.clear();
      pageSize_ = 0;

      currPage_ = 0;

      totalCount_ = 0;

      totalPage_ = 0;

      if (listBuilder_ == null) {
        list_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000010);
      } else {
        listBuilder_.clear();
      }
      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.topsec.mobiapi.proto.Channel.internal_static_com_topsec_mobiapi_proto_ChannelTechnicianEntity_descriptor;
    }

    public com.topsec.mobiapi.proto.ChannelTechnicianEntity getDefaultInstanceForType() {
      return com.topsec.mobiapi.proto.ChannelTechnicianEntity.getDefaultInstance();
    }

    public com.topsec.mobiapi.proto.ChannelTechnicianEntity build() {
      com.topsec.mobiapi.proto.ChannelTechnicianEntity result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public com.topsec.mobiapi.proto.ChannelTechnicianEntity buildPartial() {
      com.topsec.mobiapi.proto.ChannelTechnicianEntity result = new com.topsec.mobiapi.proto.ChannelTechnicianEntity(this);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      result.pageSize_ = pageSize_;
      result.currPage_ = currPage_;
      result.totalCount_ = totalCount_;
      result.totalPage_ = totalPage_;
      if (listBuilder_ == null) {
        if (((bitField0_ & 0x00000010) == 0x00000010)) {
          list_ = java.util.Collections.unmodifiableList(list_);
          bitField0_ = (bitField0_ & ~0x00000010);
        }
        result.list_ = list_;
      } else {
        result.list_ = listBuilder_.build();
      }
      result.bitField0_ = to_bitField0_;
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
      if (other instanceof com.topsec.mobiapi.proto.ChannelTechnicianEntity) {
        return mergeFrom((com.topsec.mobiapi.proto.ChannelTechnicianEntity)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.topsec.mobiapi.proto.ChannelTechnicianEntity other) {
      if (other == com.topsec.mobiapi.proto.ChannelTechnicianEntity.getDefaultInstance()) return this;
      if (other.getPageSize() != 0) {
        setPageSize(other.getPageSize());
      }
      if (other.getCurrPage() != 0) {
        setCurrPage(other.getCurrPage());
      }
      if (other.getTotalCount() != 0) {
        setTotalCount(other.getTotalCount());
      }
      if (other.getTotalPage() != 0) {
        setTotalPage(other.getTotalPage());
      }
      if (listBuilder_ == null) {
        if (!other.list_.isEmpty()) {
          if (list_.isEmpty()) {
            list_ = other.list_;
            bitField0_ = (bitField0_ & ~0x00000010);
          } else {
            ensureListIsMutable();
            list_.addAll(other.list_);
          }
          onChanged();
        }
      } else {
        if (!other.list_.isEmpty()) {
          if (listBuilder_.isEmpty()) {
            listBuilder_.dispose();
            listBuilder_ = null;
            list_ = other.list_;
            bitField0_ = (bitField0_ & ~0x00000010);
            listBuilder_ = 
              com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                 getListFieldBuilder() : null;
          } else {
            listBuilder_.addAllMessages(other.list_);
          }
        }
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
      com.topsec.mobiapi.proto.ChannelTechnicianEntity parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.topsec.mobiapi.proto.ChannelTechnicianEntity) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private int pageSize_ ;
    /**
     * <pre>
     *每页数据量大小
     * </pre>
     *
     * <code>int32 pageSize = 1;</code>
     */
    public int getPageSize() {
      return pageSize_;
    }
    /**
     * <pre>
     *每页数据量大小
     * </pre>
     *
     * <code>int32 pageSize = 1;</code>
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
     * <code>int32 pageSize = 1;</code>
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
     * <code>int32 currPage = 2;</code>
     */
    public int getCurrPage() {
      return currPage_;
    }
    /**
     * <pre>
     *当前页码
     * </pre>
     *
     * <code>int32 currPage = 2;</code>
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
     * <code>int32 currPage = 2;</code>
     */
    public Builder clearCurrPage() {
      
      currPage_ = 0;
      onChanged();
      return this;
    }

    private int totalCount_ ;
    /**
     * <pre>
     *总记录数
     * </pre>
     *
     * <code>int32 totalCount = 3;</code>
     */
    public int getTotalCount() {
      return totalCount_;
    }
    /**
     * <pre>
     *总记录数
     * </pre>
     *
     * <code>int32 totalCount = 3;</code>
     */
    public Builder setTotalCount(int value) {
      
      totalCount_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     *总记录数
     * </pre>
     *
     * <code>int32 totalCount = 3;</code>
     */
    public Builder clearTotalCount() {
      
      totalCount_ = 0;
      onChanged();
      return this;
    }

    private int totalPage_ ;
    /**
     * <pre>
     *总页数
     * </pre>
     *
     * <code>int32 totalPage = 4;</code>
     */
    public int getTotalPage() {
      return totalPage_;
    }
    /**
     * <pre>
     *总页数
     * </pre>
     *
     * <code>int32 totalPage = 4;</code>
     */
    public Builder setTotalPage(int value) {
      
      totalPage_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     *总页数
     * </pre>
     *
     * <code>int32 totalPage = 4;</code>
     */
    public Builder clearTotalPage() {
      
      totalPage_ = 0;
      onChanged();
      return this;
    }

    private java.util.List<com.topsec.mobiapi.proto.ChannelTechnicianInfo> list_ =
      java.util.Collections.emptyList();
    private void ensureListIsMutable() {
      if (!((bitField0_ & 0x00000010) == 0x00000010)) {
        list_ = new java.util.ArrayList<com.topsec.mobiapi.proto.ChannelTechnicianInfo>(list_);
        bitField0_ |= 0x00000010;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
        com.topsec.mobiapi.proto.ChannelTechnicianInfo, com.topsec.mobiapi.proto.ChannelTechnicianInfo.Builder, com.topsec.mobiapi.proto.ChannelTechnicianInfoOrBuilder> listBuilder_;

    /**
     * <pre>
     *人员信息 + 证书信息
     * </pre>
     *
     * <code>repeated .com.topsec.mobiapi.proto.ChannelTechnicianInfo list = 5;</code>
     */
    public java.util.List<com.topsec.mobiapi.proto.ChannelTechnicianInfo> getListList() {
      if (listBuilder_ == null) {
        return java.util.Collections.unmodifiableList(list_);
      } else {
        return listBuilder_.getMessageList();
      }
    }
    /**
     * <pre>
     *人员信息 + 证书信息
     * </pre>
     *
     * <code>repeated .com.topsec.mobiapi.proto.ChannelTechnicianInfo list = 5;</code>
     */
    public int getListCount() {
      if (listBuilder_ == null) {
        return list_.size();
      } else {
        return listBuilder_.getCount();
      }
    }
    /**
     * <pre>
     *人员信息 + 证书信息
     * </pre>
     *
     * <code>repeated .com.topsec.mobiapi.proto.ChannelTechnicianInfo list = 5;</code>
     */
    public com.topsec.mobiapi.proto.ChannelTechnicianInfo getList(int index) {
      if (listBuilder_ == null) {
        return list_.get(index);
      } else {
        return listBuilder_.getMessage(index);
      }
    }
    /**
     * <pre>
     *人员信息 + 证书信息
     * </pre>
     *
     * <code>repeated .com.topsec.mobiapi.proto.ChannelTechnicianInfo list = 5;</code>
     */
    public Builder setList(
        int index, com.topsec.mobiapi.proto.ChannelTechnicianInfo value) {
      if (listBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureListIsMutable();
        list_.set(index, value);
        onChanged();
      } else {
        listBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <pre>
     *人员信息 + 证书信息
     * </pre>
     *
     * <code>repeated .com.topsec.mobiapi.proto.ChannelTechnicianInfo list = 5;</code>
     */
    public Builder setList(
        int index, com.topsec.mobiapi.proto.ChannelTechnicianInfo.Builder builderForValue) {
      if (listBuilder_ == null) {
        ensureListIsMutable();
        list_.set(index, builderForValue.build());
        onChanged();
      } else {
        listBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <pre>
     *人员信息 + 证书信息
     * </pre>
     *
     * <code>repeated .com.topsec.mobiapi.proto.ChannelTechnicianInfo list = 5;</code>
     */
    public Builder addList(com.topsec.mobiapi.proto.ChannelTechnicianInfo value) {
      if (listBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureListIsMutable();
        list_.add(value);
        onChanged();
      } else {
        listBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <pre>
     *人员信息 + 证书信息
     * </pre>
     *
     * <code>repeated .com.topsec.mobiapi.proto.ChannelTechnicianInfo list = 5;</code>
     */
    public Builder addList(
        int index, com.topsec.mobiapi.proto.ChannelTechnicianInfo value) {
      if (listBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureListIsMutable();
        list_.add(index, value);
        onChanged();
      } else {
        listBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <pre>
     *人员信息 + 证书信息
     * </pre>
     *
     * <code>repeated .com.topsec.mobiapi.proto.ChannelTechnicianInfo list = 5;</code>
     */
    public Builder addList(
        com.topsec.mobiapi.proto.ChannelTechnicianInfo.Builder builderForValue) {
      if (listBuilder_ == null) {
        ensureListIsMutable();
        list_.add(builderForValue.build());
        onChanged();
      } else {
        listBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <pre>
     *人员信息 + 证书信息
     * </pre>
     *
     * <code>repeated .com.topsec.mobiapi.proto.ChannelTechnicianInfo list = 5;</code>
     */
    public Builder addList(
        int index, com.topsec.mobiapi.proto.ChannelTechnicianInfo.Builder builderForValue) {
      if (listBuilder_ == null) {
        ensureListIsMutable();
        list_.add(index, builderForValue.build());
        onChanged();
      } else {
        listBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <pre>
     *人员信息 + 证书信息
     * </pre>
     *
     * <code>repeated .com.topsec.mobiapi.proto.ChannelTechnicianInfo list = 5;</code>
     */
    public Builder addAllList(
        java.lang.Iterable<? extends com.topsec.mobiapi.proto.ChannelTechnicianInfo> values) {
      if (listBuilder_ == null) {
        ensureListIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, list_);
        onChanged();
      } else {
        listBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <pre>
     *人员信息 + 证书信息
     * </pre>
     *
     * <code>repeated .com.topsec.mobiapi.proto.ChannelTechnicianInfo list = 5;</code>
     */
    public Builder clearList() {
      if (listBuilder_ == null) {
        list_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000010);
        onChanged();
      } else {
        listBuilder_.clear();
      }
      return this;
    }
    /**
     * <pre>
     *人员信息 + 证书信息
     * </pre>
     *
     * <code>repeated .com.topsec.mobiapi.proto.ChannelTechnicianInfo list = 5;</code>
     */
    public Builder removeList(int index) {
      if (listBuilder_ == null) {
        ensureListIsMutable();
        list_.remove(index);
        onChanged();
      } else {
        listBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <pre>
     *人员信息 + 证书信息
     * </pre>
     *
     * <code>repeated .com.topsec.mobiapi.proto.ChannelTechnicianInfo list = 5;</code>
     */
    public com.topsec.mobiapi.proto.ChannelTechnicianInfo.Builder getListBuilder(
        int index) {
      return getListFieldBuilder().getBuilder(index);
    }
    /**
     * <pre>
     *人员信息 + 证书信息
     * </pre>
     *
     * <code>repeated .com.topsec.mobiapi.proto.ChannelTechnicianInfo list = 5;</code>
     */
    public com.topsec.mobiapi.proto.ChannelTechnicianInfoOrBuilder getListOrBuilder(
        int index) {
      if (listBuilder_ == null) {
        return list_.get(index);  } else {
        return listBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <pre>
     *人员信息 + 证书信息
     * </pre>
     *
     * <code>repeated .com.topsec.mobiapi.proto.ChannelTechnicianInfo list = 5;</code>
     */
    public java.util.List<? extends com.topsec.mobiapi.proto.ChannelTechnicianInfoOrBuilder> 
         getListOrBuilderList() {
      if (listBuilder_ != null) {
        return listBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(list_);
      }
    }
    /**
     * <pre>
     *人员信息 + 证书信息
     * </pre>
     *
     * <code>repeated .com.topsec.mobiapi.proto.ChannelTechnicianInfo list = 5;</code>
     */
    public com.topsec.mobiapi.proto.ChannelTechnicianInfo.Builder addListBuilder() {
      return getListFieldBuilder().addBuilder(
          com.topsec.mobiapi.proto.ChannelTechnicianInfo.getDefaultInstance());
    }
    /**
     * <pre>
     *人员信息 + 证书信息
     * </pre>
     *
     * <code>repeated .com.topsec.mobiapi.proto.ChannelTechnicianInfo list = 5;</code>
     */
    public com.topsec.mobiapi.proto.ChannelTechnicianInfo.Builder addListBuilder(
        int index) {
      return getListFieldBuilder().addBuilder(
          index, com.topsec.mobiapi.proto.ChannelTechnicianInfo.getDefaultInstance());
    }
    /**
     * <pre>
     *人员信息 + 证书信息
     * </pre>
     *
     * <code>repeated .com.topsec.mobiapi.proto.ChannelTechnicianInfo list = 5;</code>
     */
    public java.util.List<com.topsec.mobiapi.proto.ChannelTechnicianInfo.Builder> 
         getListBuilderList() {
      return getListFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilderV3<
        com.topsec.mobiapi.proto.ChannelTechnicianInfo, com.topsec.mobiapi.proto.ChannelTechnicianInfo.Builder, com.topsec.mobiapi.proto.ChannelTechnicianInfoOrBuilder> 
        getListFieldBuilder() {
      if (listBuilder_ == null) {
        listBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
            com.topsec.mobiapi.proto.ChannelTechnicianInfo, com.topsec.mobiapi.proto.ChannelTechnicianInfo.Builder, com.topsec.mobiapi.proto.ChannelTechnicianInfoOrBuilder>(
                list_,
                ((bitField0_ & 0x00000010) == 0x00000010),
                getParentForChildren(),
                isClean());
        list_ = null;
      }
      return listBuilder_;
    }
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFieldsProto3(unknownFields);
    }

    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:com.topsec.mobiapi.proto.ChannelTechnicianEntity)
  }

  // @@protoc_insertion_point(class_scope:com.topsec.mobiapi.proto.ChannelTechnicianEntity)
  private static final com.topsec.mobiapi.proto.ChannelTechnicianEntity DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.topsec.mobiapi.proto.ChannelTechnicianEntity();
  }

  public static com.topsec.mobiapi.proto.ChannelTechnicianEntity getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<ChannelTechnicianEntity>
      PARSER = new com.google.protobuf.AbstractParser<ChannelTechnicianEntity>() {
    public ChannelTechnicianEntity parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new ChannelTechnicianEntity(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<ChannelTechnicianEntity> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<ChannelTechnicianEntity> getParserForType() {
    return PARSER;
  }

  public com.topsec.mobiapi.proto.ChannelTechnicianEntity getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}


package com.topsec.mobiapi.proto;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 * <pre>
 * 渠道服务
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.21.0)",
    comments = "Source: channel.proto")
public final class ChannelServiceGrpc {

  private ChannelServiceGrpc() {}

  public static final String SERVICE_NAME = "com.topsec.mobiapi.proto.ChannelService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.topsec.mobiapi.proto.ChannelTechnicianInfoRequest,
      com.topsec.mobiapi.proto.ChannelTechnicianInfoListResponse> getQueryAllChannelTechniciansMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "QueryAllChannelTechnicians",
      requestType = com.topsec.mobiapi.proto.ChannelTechnicianInfoRequest.class,
      responseType = com.topsec.mobiapi.proto.ChannelTechnicianInfoListResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.topsec.mobiapi.proto.ChannelTechnicianInfoRequest,
      com.topsec.mobiapi.proto.ChannelTechnicianInfoListResponse> getQueryAllChannelTechniciansMethod() {
    io.grpc.MethodDescriptor<com.topsec.mobiapi.proto.ChannelTechnicianInfoRequest, com.topsec.mobiapi.proto.ChannelTechnicianInfoListResponse> getQueryAllChannelTechniciansMethod;
    if ((getQueryAllChannelTechniciansMethod = ChannelServiceGrpc.getQueryAllChannelTechniciansMethod) == null) {
      synchronized (ChannelServiceGrpc.class) {
        if ((getQueryAllChannelTechniciansMethod = ChannelServiceGrpc.getQueryAllChannelTechniciansMethod) == null) {
          ChannelServiceGrpc.getQueryAllChannelTechniciansMethod = getQueryAllChannelTechniciansMethod = 
              io.grpc.MethodDescriptor.<com.topsec.mobiapi.proto.ChannelTechnicianInfoRequest, com.topsec.mobiapi.proto.ChannelTechnicianInfoListResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "com.topsec.mobiapi.proto.ChannelService", "QueryAllChannelTechnicians"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.topsec.mobiapi.proto.ChannelTechnicianInfoRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.topsec.mobiapi.proto.ChannelTechnicianInfoListResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new ChannelServiceMethodDescriptorSupplier("QueryAllChannelTechnicians"))
                  .build();
          }
        }
     }
     return getQueryAllChannelTechniciansMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.topsec.mobiapi.proto.ChannelCompanyInfoRequest,
      com.topsec.mobiapi.proto.ChannelCompanyInfoListResponse> getQueryAllChannelCompanysMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "QueryAllChannelCompanys",
      requestType = com.topsec.mobiapi.proto.ChannelCompanyInfoRequest.class,
      responseType = com.topsec.mobiapi.proto.ChannelCompanyInfoListResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.topsec.mobiapi.proto.ChannelCompanyInfoRequest,
      com.topsec.mobiapi.proto.ChannelCompanyInfoListResponse> getQueryAllChannelCompanysMethod() {
    io.grpc.MethodDescriptor<com.topsec.mobiapi.proto.ChannelCompanyInfoRequest, com.topsec.mobiapi.proto.ChannelCompanyInfoListResponse> getQueryAllChannelCompanysMethod;
    if ((getQueryAllChannelCompanysMethod = ChannelServiceGrpc.getQueryAllChannelCompanysMethod) == null) {
      synchronized (ChannelServiceGrpc.class) {
        if ((getQueryAllChannelCompanysMethod = ChannelServiceGrpc.getQueryAllChannelCompanysMethod) == null) {
          ChannelServiceGrpc.getQueryAllChannelCompanysMethod = getQueryAllChannelCompanysMethod = 
              io.grpc.MethodDescriptor.<com.topsec.mobiapi.proto.ChannelCompanyInfoRequest, com.topsec.mobiapi.proto.ChannelCompanyInfoListResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "com.topsec.mobiapi.proto.ChannelService", "QueryAllChannelCompanys"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.topsec.mobiapi.proto.ChannelCompanyInfoRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.topsec.mobiapi.proto.ChannelCompanyInfoListResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new ChannelServiceMethodDescriptorSupplier("QueryAllChannelCompanys"))
                  .build();
          }
        }
     }
     return getQueryAllChannelCompanysMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ChannelServiceStub newStub(io.grpc.Channel channel) {
    return new ChannelServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ChannelServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new ChannelServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ChannelServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new ChannelServiceFutureStub(channel);
  }

  /**
   * <pre>
   * 渠道服务
   * </pre>
   */
  public static abstract class ChannelServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * 分页查询出所有的渠道技术人员
     * </pre>
     */
    public void queryAllChannelTechnicians(com.topsec.mobiapi.proto.ChannelTechnicianInfoRequest request,
        io.grpc.stub.StreamObserver<com.topsec.mobiapi.proto.ChannelTechnicianInfoListResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getQueryAllChannelTechniciansMethod(), responseObserver);
    }

    /**
     * <pre>
     * 分页查询出所有的渠道商
     * </pre>
     */
    public void queryAllChannelCompanys(com.topsec.mobiapi.proto.ChannelCompanyInfoRequest request,
        io.grpc.stub.StreamObserver<com.topsec.mobiapi.proto.ChannelCompanyInfoListResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getQueryAllChannelCompanysMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getQueryAllChannelTechniciansMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.topsec.mobiapi.proto.ChannelTechnicianInfoRequest,
                com.topsec.mobiapi.proto.ChannelTechnicianInfoListResponse>(
                  this, METHODID_QUERY_ALL_CHANNEL_TECHNICIANS)))
          .addMethod(
            getQueryAllChannelCompanysMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.topsec.mobiapi.proto.ChannelCompanyInfoRequest,
                com.topsec.mobiapi.proto.ChannelCompanyInfoListResponse>(
                  this, METHODID_QUERY_ALL_CHANNEL_COMPANYS)))
          .build();
    }
  }

  /**
   * <pre>
   * 渠道服务
   * </pre>
   */
  public static final class ChannelServiceStub extends io.grpc.stub.AbstractStub<ChannelServiceStub> {
    private ChannelServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ChannelServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ChannelServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ChannelServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * 分页查询出所有的渠道技术人员
     * </pre>
     */
    public void queryAllChannelTechnicians(com.topsec.mobiapi.proto.ChannelTechnicianInfoRequest request,
        io.grpc.stub.StreamObserver<com.topsec.mobiapi.proto.ChannelTechnicianInfoListResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getQueryAllChannelTechniciansMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * 分页查询出所有的渠道商
     * </pre>
     */
    public void queryAllChannelCompanys(com.topsec.mobiapi.proto.ChannelCompanyInfoRequest request,
        io.grpc.stub.StreamObserver<com.topsec.mobiapi.proto.ChannelCompanyInfoListResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getQueryAllChannelCompanysMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * 渠道服务
   * </pre>
   */
  public static final class ChannelServiceBlockingStub extends io.grpc.stub.AbstractStub<ChannelServiceBlockingStub> {
    private ChannelServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ChannelServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ChannelServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ChannelServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * 分页查询出所有的渠道技术人员
     * </pre>
     */
    public com.topsec.mobiapi.proto.ChannelTechnicianInfoListResponse queryAllChannelTechnicians(com.topsec.mobiapi.proto.ChannelTechnicianInfoRequest request) {
      return blockingUnaryCall(
          getChannel(), getQueryAllChannelTechniciansMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * 分页查询出所有的渠道商
     * </pre>
     */
    public com.topsec.mobiapi.proto.ChannelCompanyInfoListResponse queryAllChannelCompanys(com.topsec.mobiapi.proto.ChannelCompanyInfoRequest request) {
      return blockingUnaryCall(
          getChannel(), getQueryAllChannelCompanysMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * 渠道服务
   * </pre>
   */
  public static final class ChannelServiceFutureStub extends io.grpc.stub.AbstractStub<ChannelServiceFutureStub> {
    private ChannelServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ChannelServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ChannelServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ChannelServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * 分页查询出所有的渠道技术人员
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.topsec.mobiapi.proto.ChannelTechnicianInfoListResponse> queryAllChannelTechnicians(
        com.topsec.mobiapi.proto.ChannelTechnicianInfoRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getQueryAllChannelTechniciansMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * 分页查询出所有的渠道商
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.topsec.mobiapi.proto.ChannelCompanyInfoListResponse> queryAllChannelCompanys(
        com.topsec.mobiapi.proto.ChannelCompanyInfoRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getQueryAllChannelCompanysMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_QUERY_ALL_CHANNEL_TECHNICIANS = 0;
  private static final int METHODID_QUERY_ALL_CHANNEL_COMPANYS = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ChannelServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ChannelServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_QUERY_ALL_CHANNEL_TECHNICIANS:
          serviceImpl.queryAllChannelTechnicians((com.topsec.mobiapi.proto.ChannelTechnicianInfoRequest) request,
              (io.grpc.stub.StreamObserver<com.topsec.mobiapi.proto.ChannelTechnicianInfoListResponse>) responseObserver);
          break;
        case METHODID_QUERY_ALL_CHANNEL_COMPANYS:
          serviceImpl.queryAllChannelCompanys((com.topsec.mobiapi.proto.ChannelCompanyInfoRequest) request,
              (io.grpc.stub.StreamObserver<com.topsec.mobiapi.proto.ChannelCompanyInfoListResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class ChannelServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ChannelServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.topsec.mobiapi.proto.Channel.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ChannelService");
    }
  }

  private static final class ChannelServiceFileDescriptorSupplier
      extends ChannelServiceBaseDescriptorSupplier {
    ChannelServiceFileDescriptorSupplier() {}
  }

  private static final class ChannelServiceMethodDescriptorSupplier
      extends ChannelServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ChannelServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (ChannelServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ChannelServiceFileDescriptorSupplier())
              .addMethod(getQueryAllChannelTechniciansMethod())
              .addMethod(getQueryAllChannelCompanysMethod())
              .build();
        }
      }
    }
    return result;
  }
}

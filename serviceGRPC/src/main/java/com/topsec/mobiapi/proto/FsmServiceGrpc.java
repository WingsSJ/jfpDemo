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
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.21.0)",
    comments = "Source: fileManage.proto")
public final class FsmServiceGrpc {

  private FsmServiceGrpc() {}

  public static final String SERVICE_NAME = "com.topsec.mobiapi.proto.FsmService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.topsec.mobiapi.proto.FileQueryRequest,
      com.topsec.mobiapi.proto.GetFileInfoResponse> getGetFileListMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getFileList",
      requestType = com.topsec.mobiapi.proto.FileQueryRequest.class,
      responseType = com.topsec.mobiapi.proto.GetFileInfoResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.topsec.mobiapi.proto.FileQueryRequest,
      com.topsec.mobiapi.proto.GetFileInfoResponse> getGetFileListMethod() {
    io.grpc.MethodDescriptor<com.topsec.mobiapi.proto.FileQueryRequest, com.topsec.mobiapi.proto.GetFileInfoResponse> getGetFileListMethod;
    if ((getGetFileListMethod = FsmServiceGrpc.getGetFileListMethod) == null) {
      synchronized (FsmServiceGrpc.class) {
        if ((getGetFileListMethod = FsmServiceGrpc.getGetFileListMethod) == null) {
          FsmServiceGrpc.getGetFileListMethod = getGetFileListMethod = 
              io.grpc.MethodDescriptor.<com.topsec.mobiapi.proto.FileQueryRequest, com.topsec.mobiapi.proto.GetFileInfoResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "com.topsec.mobiapi.proto.FsmService", "getFileList"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.topsec.mobiapi.proto.FileQueryRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.topsec.mobiapi.proto.GetFileInfoResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new FsmServiceMethodDescriptorSupplier("getFileList"))
                  .build();
          }
        }
     }
     return getGetFileListMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static FsmServiceStub newStub(io.grpc.Channel channel) {
    return new FsmServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static FsmServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new FsmServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static FsmServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new FsmServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class FsmServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getFileList(com.topsec.mobiapi.proto.FileQueryRequest request,
        io.grpc.stub.StreamObserver<com.topsec.mobiapi.proto.GetFileInfoResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetFileListMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetFileListMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.topsec.mobiapi.proto.FileQueryRequest,
                com.topsec.mobiapi.proto.GetFileInfoResponse>(
                  this, METHODID_GET_FILE_LIST)))
          .build();
    }
  }

  /**
   */
  public static final class FsmServiceStub extends io.grpc.stub.AbstractStub<FsmServiceStub> {
    private FsmServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private FsmServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FsmServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new FsmServiceStub(channel, callOptions);
    }

    /**
     */
    public void getFileList(com.topsec.mobiapi.proto.FileQueryRequest request,
        io.grpc.stub.StreamObserver<com.topsec.mobiapi.proto.GetFileInfoResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetFileListMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class FsmServiceBlockingStub extends io.grpc.stub.AbstractStub<FsmServiceBlockingStub> {
    private FsmServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private FsmServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FsmServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new FsmServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.topsec.mobiapi.proto.GetFileInfoResponse getFileList(com.topsec.mobiapi.proto.FileQueryRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetFileListMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class FsmServiceFutureStub extends io.grpc.stub.AbstractStub<FsmServiceFutureStub> {
    private FsmServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private FsmServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FsmServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new FsmServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.topsec.mobiapi.proto.GetFileInfoResponse> getFileList(
        com.topsec.mobiapi.proto.FileQueryRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetFileListMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_FILE_LIST = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final FsmServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(FsmServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_FILE_LIST:
          serviceImpl.getFileList((com.topsec.mobiapi.proto.FileQueryRequest) request,
              (io.grpc.stub.StreamObserver<com.topsec.mobiapi.proto.GetFileInfoResponse>) responseObserver);
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

  private static abstract class FsmServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    FsmServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.topsec.mobiapi.proto.FileManage.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("FsmService");
    }
  }

  private static final class FsmServiceFileDescriptorSupplier
      extends FsmServiceBaseDescriptorSupplier {
    FsmServiceFileDescriptorSupplier() {}
  }

  private static final class FsmServiceMethodDescriptorSupplier
      extends FsmServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    FsmServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (FsmServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new FsmServiceFileDescriptorSupplier())
              .addMethod(getGetFileListMethod())
              .build();
        }
      }
    }
    return result;
  }
}

package generated;

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
 * Interface exported by the server.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.33.0)",
    comments = "Source: scheme.proto")
public final class ServerCommunicationGrpc {

  private ServerCommunicationGrpc() {}

  public static final String SERVICE_NAME = "servercommunication.ServerCommunication";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<generated.RideRequest,
      generated.RideOffer> getHasCompatibleRideMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "hasCompatibleRide",
      requestType = generated.RideRequest.class,
      responseType = generated.RideOffer.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<generated.RideRequest,
      generated.RideOffer> getHasCompatibleRideMethod() {
    io.grpc.MethodDescriptor<generated.RideRequest, generated.RideOffer> getHasCompatibleRideMethod;
    if ((getHasCompatibleRideMethod = ServerCommunicationGrpc.getHasCompatibleRideMethod) == null) {
      synchronized (ServerCommunicationGrpc.class) {
        if ((getHasCompatibleRideMethod = ServerCommunicationGrpc.getHasCompatibleRideMethod) == null) {
          ServerCommunicationGrpc.getHasCompatibleRideMethod = getHasCompatibleRideMethod =
              io.grpc.MethodDescriptor.<generated.RideRequest, generated.RideOffer>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "hasCompatibleRide"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.RideRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.RideOffer.getDefaultInstance()))
              .setSchemaDescriptor(new ServerCommunicationMethodDescriptorSupplier("hasCompatibleRide"))
              .build();
        }
      }
    }
    return getHasCompatibleRideMethod;
  }

  private static volatile io.grpc.MethodDescriptor<generated.RideOffer,
      generated.RideOffer> getOccupyRideMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "occupyRide",
      requestType = generated.RideOffer.class,
      responseType = generated.RideOffer.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<generated.RideOffer,
      generated.RideOffer> getOccupyRideMethod() {
    io.grpc.MethodDescriptor<generated.RideOffer, generated.RideOffer> getOccupyRideMethod;
    if ((getOccupyRideMethod = ServerCommunicationGrpc.getOccupyRideMethod) == null) {
      synchronized (ServerCommunicationGrpc.class) {
        if ((getOccupyRideMethod = ServerCommunicationGrpc.getOccupyRideMethod) == null) {
          ServerCommunicationGrpc.getOccupyRideMethod = getOccupyRideMethod =
              io.grpc.MethodDescriptor.<generated.RideOffer, generated.RideOffer>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "occupyRide"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.RideOffer.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.RideOffer.getDefaultInstance()))
              .setSchemaDescriptor(new ServerCommunicationMethodDescriptorSupplier("occupyRide"))
              .build();
        }
      }
    }
    return getOccupyRideMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ServerCommunicationStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ServerCommunicationStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ServerCommunicationStub>() {
        @java.lang.Override
        public ServerCommunicationStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ServerCommunicationStub(channel, callOptions);
        }
      };
    return ServerCommunicationStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ServerCommunicationBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ServerCommunicationBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ServerCommunicationBlockingStub>() {
        @java.lang.Override
        public ServerCommunicationBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ServerCommunicationBlockingStub(channel, callOptions);
        }
      };
    return ServerCommunicationBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ServerCommunicationFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ServerCommunicationFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ServerCommunicationFutureStub>() {
        @java.lang.Override
        public ServerCommunicationFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ServerCommunicationFutureStub(channel, callOptions);
        }
      };
    return ServerCommunicationFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static abstract class ServerCommunicationImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * A server-to-client streaming RPC.
     * Obtains the Features available within the given Rectangle.  Results are
     * streamed rather than returned at once (e.g. in a response message with a
     * repeated field), as the rectangle may cover a large area and contain a
     * huge number of features.
     * </pre>
     */
    public void hasCompatibleRide(generated.RideRequest request,
        io.grpc.stub.StreamObserver<generated.RideOffer> responseObserver) {
      asyncUnimplementedUnaryCall(getHasCompatibleRideMethod(), responseObserver);
    }

    /**
     * <pre>
     * A Bidirectional streaming RPC.
     * Accepts a stream of RouteNotes sent while a route is being traversed,
     * while receiving other RouteNotes (e.g. from other users).
     * </pre>
     */
    public void occupyRide(generated.RideOffer request,
        io.grpc.stub.StreamObserver<generated.RideOffer> responseObserver) {
      asyncUnimplementedUnaryCall(getOccupyRideMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getHasCompatibleRideMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                generated.RideRequest,
                generated.RideOffer>(
                  this, METHODID_HAS_COMPATIBLE_RIDE)))
          .addMethod(
            getOccupyRideMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                generated.RideOffer,
                generated.RideOffer>(
                  this, METHODID_OCCUPY_RIDE)))
          .build();
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class ServerCommunicationStub extends io.grpc.stub.AbstractAsyncStub<ServerCommunicationStub> {
    private ServerCommunicationStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ServerCommunicationStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ServerCommunicationStub(channel, callOptions);
    }

    /**
     * <pre>
     * A server-to-client streaming RPC.
     * Obtains the Features available within the given Rectangle.  Results are
     * streamed rather than returned at once (e.g. in a response message with a
     * repeated field), as the rectangle may cover a large area and contain a
     * huge number of features.
     * </pre>
     */
    public void hasCompatibleRide(generated.RideRequest request,
        io.grpc.stub.StreamObserver<generated.RideOffer> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getHasCompatibleRideMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * A Bidirectional streaming RPC.
     * Accepts a stream of RouteNotes sent while a route is being traversed,
     * while receiving other RouteNotes (e.g. from other users).
     * </pre>
     */
    public void occupyRide(generated.RideOffer request,
        io.grpc.stub.StreamObserver<generated.RideOffer> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getOccupyRideMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class ServerCommunicationBlockingStub extends io.grpc.stub.AbstractBlockingStub<ServerCommunicationBlockingStub> {
    private ServerCommunicationBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ServerCommunicationBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ServerCommunicationBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * A server-to-client streaming RPC.
     * Obtains the Features available within the given Rectangle.  Results are
     * streamed rather than returned at once (e.g. in a response message with a
     * repeated field), as the rectangle may cover a large area and contain a
     * huge number of features.
     * </pre>
     */
    public generated.RideOffer hasCompatibleRide(generated.RideRequest request) {
      return blockingUnaryCall(
          getChannel(), getHasCompatibleRideMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * A Bidirectional streaming RPC.
     * Accepts a stream of RouteNotes sent while a route is being traversed,
     * while receiving other RouteNotes (e.g. from other users).
     * </pre>
     */
    public generated.RideOffer occupyRide(generated.RideOffer request) {
      return blockingUnaryCall(
          getChannel(), getOccupyRideMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class ServerCommunicationFutureStub extends io.grpc.stub.AbstractFutureStub<ServerCommunicationFutureStub> {
    private ServerCommunicationFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ServerCommunicationFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ServerCommunicationFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * A server-to-client streaming RPC.
     * Obtains the Features available within the given Rectangle.  Results are
     * streamed rather than returned at once (e.g. in a response message with a
     * repeated field), as the rectangle may cover a large area and contain a
     * huge number of features.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<generated.RideOffer> hasCompatibleRide(
        generated.RideRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getHasCompatibleRideMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * A Bidirectional streaming RPC.
     * Accepts a stream of RouteNotes sent while a route is being traversed,
     * while receiving other RouteNotes (e.g. from other users).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<generated.RideOffer> occupyRide(
        generated.RideOffer request) {
      return futureUnaryCall(
          getChannel().newCall(getOccupyRideMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_HAS_COMPATIBLE_RIDE = 0;
  private static final int METHODID_OCCUPY_RIDE = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ServerCommunicationImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ServerCommunicationImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_HAS_COMPATIBLE_RIDE:
          serviceImpl.hasCompatibleRide((generated.RideRequest) request,
              (io.grpc.stub.StreamObserver<generated.RideOffer>) responseObserver);
          break;
        case METHODID_OCCUPY_RIDE:
          serviceImpl.occupyRide((generated.RideOffer) request,
              (io.grpc.stub.StreamObserver<generated.RideOffer>) responseObserver);
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

  private static abstract class ServerCommunicationBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ServerCommunicationBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return generated.RouteGuideProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ServerCommunication");
    }
  }

  private static final class ServerCommunicationFileDescriptorSupplier
      extends ServerCommunicationBaseDescriptorSupplier {
    ServerCommunicationFileDescriptorSupplier() {}
  }

  private static final class ServerCommunicationMethodDescriptorSupplier
      extends ServerCommunicationBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ServerCommunicationMethodDescriptorSupplier(String methodName) {
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
      synchronized (ServerCommunicationGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ServerCommunicationFileDescriptorSupplier())
              .addMethod(getHasCompatibleRideMethod())
              .addMethod(getOccupyRideMethod())
              .build();
        }
      }
    }
    return result;
  }
}

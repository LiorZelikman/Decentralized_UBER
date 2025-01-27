// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: scheme.proto

package generated;

/**
 * Protobuf type {@code servercommunication.RideOffer}
 */
public final class RideOffer extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:servercommunication.RideOffer)
    RideOfferOrBuilder {
private static final long serialVersionUID = 0L;
  // Use RideOffer.newBuilder() to construct.
  private RideOffer(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private RideOffer() {
    firstName_ = "";
    lastName_ = "";
    phone_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new RideOffer();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private RideOffer(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
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
          case 8: {

            id_ = input.readInt32();
            break;
          }
          case 18: {
            java.lang.String s = input.readStringRequireUtf8();

            firstName_ = s;
            break;
          }
          case 26: {
            java.lang.String s = input.readStringRequireUtf8();

            lastName_ = s;
            break;
          }
          case 34: {
            java.lang.String s = input.readStringRequireUtf8();

            phone_ = s;
            break;
          }
          case 40: {

            satisfied_ = input.readBool();
            break;
          }
          case 50: {
            generated.RideRequest.Builder subBuilder = null;
            if (req_ != null) {
              subBuilder = req_.toBuilder();
            }
            req_ = input.readMessage(generated.RideRequest.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(req_);
              req_ = subBuilder.buildPartial();
            }

            break;
          }
          default: {
            if (!parseUnknownField(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
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
    return generated.RouteGuideProto.internal_static_servercommunication_RideOffer_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return generated.RouteGuideProto.internal_static_servercommunication_RideOffer_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            generated.RideOffer.class, generated.RideOffer.Builder.class);
  }

  public static final int ID_FIELD_NUMBER = 1;
  private int id_;
  /**
   * <code>int32 id = 1;</code>
   * @return The id.
   */
  @java.lang.Override
  public int getId() {
    return id_;
  }

  public static final int FIRSTNAME_FIELD_NUMBER = 2;
  private volatile java.lang.Object firstName_;
  /**
   * <code>string firstName = 2;</code>
   * @return The firstName.
   */
  @java.lang.Override
  public java.lang.String getFirstName() {
    java.lang.Object ref = firstName_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      firstName_ = s;
      return s;
    }
  }
  /**
   * <code>string firstName = 2;</code>
   * @return The bytes for firstName.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getFirstNameBytes() {
    java.lang.Object ref = firstName_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      firstName_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int LASTNAME_FIELD_NUMBER = 3;
  private volatile java.lang.Object lastName_;
  /**
   * <code>string lastName = 3;</code>
   * @return The lastName.
   */
  @java.lang.Override
  public java.lang.String getLastName() {
    java.lang.Object ref = lastName_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      lastName_ = s;
      return s;
    }
  }
  /**
   * <code>string lastName = 3;</code>
   * @return The bytes for lastName.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getLastNameBytes() {
    java.lang.Object ref = lastName_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      lastName_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int PHONE_FIELD_NUMBER = 4;
  private volatile java.lang.Object phone_;
  /**
   * <code>string phone = 4;</code>
   * @return The phone.
   */
  @java.lang.Override
  public java.lang.String getPhone() {
    java.lang.Object ref = phone_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      phone_ = s;
      return s;
    }
  }
  /**
   * <code>string phone = 4;</code>
   * @return The bytes for phone.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getPhoneBytes() {
    java.lang.Object ref = phone_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      phone_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int SATISFIED_FIELD_NUMBER = 5;
  private boolean satisfied_;
  /**
   * <code>bool satisfied = 5;</code>
   * @return The satisfied.
   */
  @java.lang.Override
  public boolean getSatisfied() {
    return satisfied_;
  }

  public static final int REQ_FIELD_NUMBER = 6;
  private generated.RideRequest req_;
  /**
   * <code>.servercommunication.RideRequest req = 6;</code>
   * @return Whether the req field is set.
   */
  @java.lang.Override
  public boolean hasReq() {
    return req_ != null;
  }
  /**
   * <code>.servercommunication.RideRequest req = 6;</code>
   * @return The req.
   */
  @java.lang.Override
  public generated.RideRequest getReq() {
    return req_ == null ? generated.RideRequest.getDefaultInstance() : req_;
  }
  /**
   * <code>.servercommunication.RideRequest req = 6;</code>
   */
  @java.lang.Override
  public generated.RideRequestOrBuilder getReqOrBuilder() {
    return getReq();
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (id_ != 0) {
      output.writeInt32(1, id_);
    }
    if (!getFirstNameBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, firstName_);
    }
    if (!getLastNameBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 3, lastName_);
    }
    if (!getPhoneBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 4, phone_);
    }
    if (satisfied_ != false) {
      output.writeBool(5, satisfied_);
    }
    if (req_ != null) {
      output.writeMessage(6, getReq());
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (id_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(1, id_);
    }
    if (!getFirstNameBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, firstName_);
    }
    if (!getLastNameBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, lastName_);
    }
    if (!getPhoneBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(4, phone_);
    }
    if (satisfied_ != false) {
      size += com.google.protobuf.CodedOutputStream
        .computeBoolSize(5, satisfied_);
    }
    if (req_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(6, getReq());
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
    if (!(obj instanceof generated.RideOffer)) {
      return super.equals(obj);
    }
    generated.RideOffer other = (generated.RideOffer) obj;

    if (getId()
        != other.getId()) return false;
    if (!getFirstName()
        .equals(other.getFirstName())) return false;
    if (!getLastName()
        .equals(other.getLastName())) return false;
    if (!getPhone()
        .equals(other.getPhone())) return false;
    if (getSatisfied()
        != other.getSatisfied()) return false;
    if (hasReq() != other.hasReq()) return false;
    if (hasReq()) {
      if (!getReq()
          .equals(other.getReq())) return false;
    }
    if (!unknownFields.equals(other.unknownFields)) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + ID_FIELD_NUMBER;
    hash = (53 * hash) + getId();
    hash = (37 * hash) + FIRSTNAME_FIELD_NUMBER;
    hash = (53 * hash) + getFirstName().hashCode();
    hash = (37 * hash) + LASTNAME_FIELD_NUMBER;
    hash = (53 * hash) + getLastName().hashCode();
    hash = (37 * hash) + PHONE_FIELD_NUMBER;
    hash = (53 * hash) + getPhone().hashCode();
    hash = (37 * hash) + SATISFIED_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(
        getSatisfied());
    if (hasReq()) {
      hash = (37 * hash) + REQ_FIELD_NUMBER;
      hash = (53 * hash) + getReq().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static generated.RideOffer parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static generated.RideOffer parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static generated.RideOffer parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static generated.RideOffer parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static generated.RideOffer parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static generated.RideOffer parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static generated.RideOffer parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static generated.RideOffer parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static generated.RideOffer parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static generated.RideOffer parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static generated.RideOffer parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static generated.RideOffer parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(generated.RideOffer prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
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
   * Protobuf type {@code servercommunication.RideOffer}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:servercommunication.RideOffer)
      generated.RideOfferOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return generated.RouteGuideProto.internal_static_servercommunication_RideOffer_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return generated.RouteGuideProto.internal_static_servercommunication_RideOffer_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              generated.RideOffer.class, generated.RideOffer.Builder.class);
    }

    // Construct using generated.RideOffer.newBuilder()
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
    @java.lang.Override
    public Builder clear() {
      super.clear();
      id_ = 0;

      firstName_ = "";

      lastName_ = "";

      phone_ = "";

      satisfied_ = false;

      if (reqBuilder_ == null) {
        req_ = null;
      } else {
        req_ = null;
        reqBuilder_ = null;
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return generated.RouteGuideProto.internal_static_servercommunication_RideOffer_descriptor;
    }

    @java.lang.Override
    public generated.RideOffer getDefaultInstanceForType() {
      return generated.RideOffer.getDefaultInstance();
    }

    @java.lang.Override
    public generated.RideOffer build() {
      generated.RideOffer result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public generated.RideOffer buildPartial() {
      generated.RideOffer result = new generated.RideOffer(this);
      result.id_ = id_;
      result.firstName_ = firstName_;
      result.lastName_ = lastName_;
      result.phone_ = phone_;
      result.satisfied_ = satisfied_;
      if (reqBuilder_ == null) {
        result.req_ = req_;
      } else {
        result.req_ = reqBuilder_.build();
      }
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof generated.RideOffer) {
        return mergeFrom((generated.RideOffer)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(generated.RideOffer other) {
      if (other == generated.RideOffer.getDefaultInstance()) return this;
      if (other.getId() != 0) {
        setId(other.getId());
      }
      if (!other.getFirstName().isEmpty()) {
        firstName_ = other.firstName_;
        onChanged();
      }
      if (!other.getLastName().isEmpty()) {
        lastName_ = other.lastName_;
        onChanged();
      }
      if (!other.getPhone().isEmpty()) {
        phone_ = other.phone_;
        onChanged();
      }
      if (other.getSatisfied() != false) {
        setSatisfied(other.getSatisfied());
      }
      if (other.hasReq()) {
        mergeReq(other.getReq());
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      generated.RideOffer parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (generated.RideOffer) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private int id_ ;
    /**
     * <code>int32 id = 1;</code>
     * @return The id.
     */
    @java.lang.Override
    public int getId() {
      return id_;
    }
    /**
     * <code>int32 id = 1;</code>
     * @param value The id to set.
     * @return This builder for chaining.
     */
    public Builder setId(int value) {
      
      id_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 id = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearId() {
      
      id_ = 0;
      onChanged();
      return this;
    }

    private java.lang.Object firstName_ = "";
    /**
     * <code>string firstName = 2;</code>
     * @return The firstName.
     */
    public java.lang.String getFirstName() {
      java.lang.Object ref = firstName_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        firstName_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string firstName = 2;</code>
     * @return The bytes for firstName.
     */
    public com.google.protobuf.ByteString
        getFirstNameBytes() {
      java.lang.Object ref = firstName_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        firstName_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string firstName = 2;</code>
     * @param value The firstName to set.
     * @return This builder for chaining.
     */
    public Builder setFirstName(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      firstName_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string firstName = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearFirstName() {
      
      firstName_ = getDefaultInstance().getFirstName();
      onChanged();
      return this;
    }
    /**
     * <code>string firstName = 2;</code>
     * @param value The bytes for firstName to set.
     * @return This builder for chaining.
     */
    public Builder setFirstNameBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      firstName_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object lastName_ = "";
    /**
     * <code>string lastName = 3;</code>
     * @return The lastName.
     */
    public java.lang.String getLastName() {
      java.lang.Object ref = lastName_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        lastName_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string lastName = 3;</code>
     * @return The bytes for lastName.
     */
    public com.google.protobuf.ByteString
        getLastNameBytes() {
      java.lang.Object ref = lastName_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        lastName_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string lastName = 3;</code>
     * @param value The lastName to set.
     * @return This builder for chaining.
     */
    public Builder setLastName(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      lastName_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string lastName = 3;</code>
     * @return This builder for chaining.
     */
    public Builder clearLastName() {
      
      lastName_ = getDefaultInstance().getLastName();
      onChanged();
      return this;
    }
    /**
     * <code>string lastName = 3;</code>
     * @param value The bytes for lastName to set.
     * @return This builder for chaining.
     */
    public Builder setLastNameBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      lastName_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object phone_ = "";
    /**
     * <code>string phone = 4;</code>
     * @return The phone.
     */
    public java.lang.String getPhone() {
      java.lang.Object ref = phone_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        phone_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string phone = 4;</code>
     * @return The bytes for phone.
     */
    public com.google.protobuf.ByteString
        getPhoneBytes() {
      java.lang.Object ref = phone_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        phone_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string phone = 4;</code>
     * @param value The phone to set.
     * @return This builder for chaining.
     */
    public Builder setPhone(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      phone_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string phone = 4;</code>
     * @return This builder for chaining.
     */
    public Builder clearPhone() {
      
      phone_ = getDefaultInstance().getPhone();
      onChanged();
      return this;
    }
    /**
     * <code>string phone = 4;</code>
     * @param value The bytes for phone to set.
     * @return This builder for chaining.
     */
    public Builder setPhoneBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      phone_ = value;
      onChanged();
      return this;
    }

    private boolean satisfied_ ;
    /**
     * <code>bool satisfied = 5;</code>
     * @return The satisfied.
     */
    @java.lang.Override
    public boolean getSatisfied() {
      return satisfied_;
    }
    /**
     * <code>bool satisfied = 5;</code>
     * @param value The satisfied to set.
     * @return This builder for chaining.
     */
    public Builder setSatisfied(boolean value) {
      
      satisfied_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>bool satisfied = 5;</code>
     * @return This builder for chaining.
     */
    public Builder clearSatisfied() {
      
      satisfied_ = false;
      onChanged();
      return this;
    }

    private generated.RideRequest req_;
    private com.google.protobuf.SingleFieldBuilderV3<
        generated.RideRequest, generated.RideRequest.Builder, generated.RideRequestOrBuilder> reqBuilder_;
    /**
     * <code>.servercommunication.RideRequest req = 6;</code>
     * @return Whether the req field is set.
     */
    public boolean hasReq() {
      return reqBuilder_ != null || req_ != null;
    }
    /**
     * <code>.servercommunication.RideRequest req = 6;</code>
     * @return The req.
     */
    public generated.RideRequest getReq() {
      if (reqBuilder_ == null) {
        return req_ == null ? generated.RideRequest.getDefaultInstance() : req_;
      } else {
        return reqBuilder_.getMessage();
      }
    }
    /**
     * <code>.servercommunication.RideRequest req = 6;</code>
     */
    public Builder setReq(generated.RideRequest value) {
      if (reqBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        req_ = value;
        onChanged();
      } else {
        reqBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>.servercommunication.RideRequest req = 6;</code>
     */
    public Builder setReq(
        generated.RideRequest.Builder builderForValue) {
      if (reqBuilder_ == null) {
        req_ = builderForValue.build();
        onChanged();
      } else {
        reqBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>.servercommunication.RideRequest req = 6;</code>
     */
    public Builder mergeReq(generated.RideRequest value) {
      if (reqBuilder_ == null) {
        if (req_ != null) {
          req_ =
            generated.RideRequest.newBuilder(req_).mergeFrom(value).buildPartial();
        } else {
          req_ = value;
        }
        onChanged();
      } else {
        reqBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>.servercommunication.RideRequest req = 6;</code>
     */
    public Builder clearReq() {
      if (reqBuilder_ == null) {
        req_ = null;
        onChanged();
      } else {
        req_ = null;
        reqBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>.servercommunication.RideRequest req = 6;</code>
     */
    public generated.RideRequest.Builder getReqBuilder() {
      
      onChanged();
      return getReqFieldBuilder().getBuilder();
    }
    /**
     * <code>.servercommunication.RideRequest req = 6;</code>
     */
    public generated.RideRequestOrBuilder getReqOrBuilder() {
      if (reqBuilder_ != null) {
        return reqBuilder_.getMessageOrBuilder();
      } else {
        return req_ == null ?
            generated.RideRequest.getDefaultInstance() : req_;
      }
    }
    /**
     * <code>.servercommunication.RideRequest req = 6;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        generated.RideRequest, generated.RideRequest.Builder, generated.RideRequestOrBuilder> 
        getReqFieldBuilder() {
      if (reqBuilder_ == null) {
        reqBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            generated.RideRequest, generated.RideRequest.Builder, generated.RideRequestOrBuilder>(
                getReq(),
                getParentForChildren(),
                isClean());
        req_ = null;
      }
      return reqBuilder_;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:servercommunication.RideOffer)
  }

  // @@protoc_insertion_point(class_scope:servercommunication.RideOffer)
  private static final generated.RideOffer DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new generated.RideOffer();
  }

  public static generated.RideOffer getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<RideOffer>
      PARSER = new com.google.protobuf.AbstractParser<RideOffer>() {
    @java.lang.Override
    public RideOffer parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new RideOffer(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<RideOffer> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<RideOffer> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public generated.RideOffer getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}


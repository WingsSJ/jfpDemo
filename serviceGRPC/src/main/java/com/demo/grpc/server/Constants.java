package com.demo.grpc.server;

import com.topsec.ptoken.core.Token;
import io.grpc.Context;
import io.grpc.Metadata;

public class Constants {
    public static final Metadata.Key<String> PTOKEN_META_KEY = Metadata.Key.of("_ptoken", Metadata.ASCII_STRING_MARSHALLER);
    public static final Context.Key<Token> PTOKEN_CTX_KEY = Context.key("ptoken");
    public static final Metadata.Key<String> SUBDIG_META_KEY = Metadata.Key.of("_subdig", Metadata.ASCII_STRING_MARSHALLER);
    public static final Metadata.Key<String> MOBI_SOFT_VER = Metadata.Key.of("_softver",Metadata.ASCII_STRING_MARSHALLER);
    public static final Context.Key<String> SUBDIG_CTX_KEY = Context.key("subdig");
    //软件版本
    public static final Integer SOFTVER=1;
}

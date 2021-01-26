package com.zrv.sprbootsrv.service;

import com.google.common.hash.Hashing;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;

@Service
public class SHA256CryptoService {
    public String getHashString(String string) {
        return Hashing.sha256().hashString(string, StandardCharsets.UTF_8).toString();
    }
}

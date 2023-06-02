# Protobuf

## Funcionamento

Os `protofiles` escritos na sintaxe de `protobufs` se relacionam muito com a tecnologia de gRPC(_Google Remote Procedure Call_).

`protofile`: é capaz de gerar código em (quase) qualquer linguagem a partir do seu arquivo.

🛠️`authentication_file.proto`:

```proto
syntax = "proto3";

package authentication;

option java_package = "com.hoogle.outstagram";
option java_multiple_files = true;

service AuthenticationService {
  rpc SignUp(SignUpRequest) returns (Profile) {}
  rpc SignIn(SignInRequest) returns (stream Profile) {}
}

message Address {
  optional string country = 1;
  optional string city = 2;
  optional string postalCode = 3;
}

message SignUpRequest {
  required string username = 1;
  required string about = 2;
  required string email = 3;
  required string password = 4;
  repeated Adress adress = 5;
}

message SignInRequest {
  required string username = 1;
  required string password = 3;
}

message Profile {
  required string username = 1;
  required string about = 2;
}
```

```json
{
  "username": "hgrafa"
  "address": {
    "city": "New York"
  }
}
```

```bash
  protoc --csharp_out=. meu_arquivo.proto
  protoc --java_out=./src authentication.proto
```

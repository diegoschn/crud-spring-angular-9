package br.com.crud.exception;

public class EntidadeNaoEncontradaException extends RuntimeException{

    private static final long UID=1L;

    private String msg;

    public EntidadeNaoEncontradaException(String msg){
        super(msg);
    }
}

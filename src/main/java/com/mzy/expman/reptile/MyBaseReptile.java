package com.mzy.expman.reptile;

import com.mzy.expman.entity.ExpRequestEntity;

import javax.script.ScriptException;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * @ClassName MyBaseReptile
 * @Description 爬虫基类
 * @Author 程方园
 * @Date 2019/12/4 14:13
 * @Version 1.0
 */
public abstract class MyBaseReptile<T> {
    abstract public CompletableFuture<T> getDownEntity(ExpRequestEntity expRequestEntity) throws IOException, ScriptException, NoSuchMethodException;

    abstract public CompletableFuture<List<T>> getDownEntityList(ExpRequestEntity expRequestEntity);
}

package com.example.mutablematrixbitmap;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class ThreadTransformers {



    public static class InputOutput <T> implements ObservableTransformer<T,T> {
        /*Этот планировщик основывается на неограниченном пуле потоков
        и используется для интенсивной работы с вводом-выводом без использования ЦП,
        например, доступ к файловой системе, выполнение сетевых вызовов,
        доступ к базе данных и так далее.
        Количество потоков в этом планировщике неограничено и может расти по мере необходимости.*/
        @Override
        public ObservableSource<T> apply(Observable<T> upstream) {
            return upstream
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread());
        }
    }
}

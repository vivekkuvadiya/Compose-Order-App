package com.example.orderapp.core.di

import android.content.Context
import androidx.room.Room
import com.example.orderapp.core.data.local.DelivererDao
import com.example.orderapp.core.data.local.OrderDao
import com.example.orderapp.core.data.local.OrderDatabase
import com.example.orderapp.core.data.local.ProductDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Singleton
    @Provides
    fun provideOrderDatabase(@ApplicationContext context: Context): OrderDatabase {
        return Room.databaseBuilder(context, OrderDatabase::class.java, "order_db").build()
    }

    @Singleton
    @Provides
    fun provideOrderDao(orderDatabase: OrderDatabase): OrderDao {
        return orderDatabase.orderDao()
    }

    @Singleton
    @Provides
    fun provideDelivererDao(orderDatabase: OrderDatabase): DelivererDao {
        return orderDatabase.delivererDao()
    }

    @Singleton
    @Provides
    fun provideProductDao(orderDatabase: OrderDatabase): ProductDao {
        return orderDatabase.productDao()
    }

}
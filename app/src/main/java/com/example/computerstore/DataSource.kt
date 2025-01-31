package com.example.computerstore

import android.content.Context
import androidx.compose.ui.res.stringResource

class DataSource {
    fun loadPhones(context: Context): List<Product> {
        return listOf(
            Product(1, context.getString(R.string.product1_name), context.getString(R.string.product1_price), R.drawable.iphone14),
            Product(2, context.getString(R.string.product2_name), context.getString(R.string.product2_price), R.drawable.iphone13),
            Product(3, context.getString(R.string.product3_name), context.getString(R.string.product3_price), R.drawable.iphone12),
            Product(4, context.getString(R.string.product4_name), context.getString(R.string.product4_price), R.drawable.iphone11)
        )
    }
    fun loadComputers(context: Context): List<Product> {
        return listOf(
            Product(5, context.getString(R.string.macbook1_name), context.getString(R.string.macbook1_price), R.drawable.macbook_pro),
            Product(6, context.getString(R.string.macbook2_name), context.getString(R.string.macbook2_price), R.drawable.macbook_pro2),
            Product(7, context.getString(R.string.macbook3_name), context.getString(R.string.macbook3_price), R.drawable.macbook_pro3),
            Product(8, context.getString(R.string.macbook4_name), context.getString(R.string.macbook4_price), R.drawable.macbook_pro4),
            Product(9, context.getString(R.string.macbook5_name), context.getString(R.string.macbook5_price), R.drawable.macbook_pro4),
            Product(10, context.getString(R.string.macbook6_name), context.getString(R.string.macbook6_price), R.drawable.macbook_pro2),
            Product(11, context.getString(R.string.macbook7_name), context.getString(R.string.macbook7_price), R.drawable.macbook_pro),
            Product(12, context.getString(R.string.macbook8_name), context.getString(R.string.macbook8_price), R.drawable.macbook_pro2)
        )
    }
    fun loadWatches(context: Context): List<Product> {
        return listOf(
            Product(13, context.getString(R.string.watch1_name), context.getString(R.string.watch1_price), R.drawable.watch1),
            Product(14, context.getString(R.string.watch2_name), context.getString(R.string.watch2_price), R.drawable.watch2),
            Product(15, context.getString(R.string.watch3_name), context.getString(R.string.watch3_price), R.drawable.watch3),
            Product(16, context.getString(R.string.watch4_name), context.getString(R.string.watch4_price), R.drawable.watch4)
        )
    }

    fun loadHeadsets(context: Context): List<Product> {
        return listOf(
            Product(17, context.getString(R.string.headset1_name), context.getString(R.string.headset1_price), R.drawable.headset1),
            Product(18, context.getString(R.string.headset2_name), context.getString(R.string.headset2_price), R.drawable.headset2),
            Product(19, context.getString(R.string.headset3_name), context.getString(R.string.headset3_price), R.drawable.headset3),
            Product(20, context.getString(R.string.headset4_name), context.getString(R.string.headset4_price), R.drawable.headset4)
        )
    }

    fun loadCamerasAndTablets(context: Context): List<Product> {
        return listOf(
            Product(21, context.getString(R.string.camera1_name), context.getString(R.string.camera1_price), R.drawable.camera1),
            Product(22, context.getString(R.string.tablet1_name), context.getString(R.string.camera2_price), R.drawable.tab1),
            Product(23, context.getString(R.string.camera3_name), context.getString(R.string.camera3_price), R.drawable.camera1),
            Product(24, context.getString(R.string.camera4_name), context.getString(R.string.camera4_price), R.drawable.camera1),
            Product(25, context.getString(R.string.tablet2_name), context.getString(R.string.camera4_price), R.drawable.tab2),
            Product(26, context.getString(R.string.tablet3_name), context.getString(R.string.camera4_price), R.drawable.tab1)
        )
    }
}
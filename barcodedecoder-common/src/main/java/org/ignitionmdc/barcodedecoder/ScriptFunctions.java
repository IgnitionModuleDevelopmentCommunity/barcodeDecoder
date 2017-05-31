package org.ignitionmdc.barcodedecoder;

//import com.google.zxing.BinaryBitmap;
//import com.google.zxing.MultiFormatReader;
//import com.google.zxing.Result;
//import com.google.zxing.common.HybridBinarizer;

import com.google.zxing.*;
import com.google.zxing.common.HybridBinarizer;

import java.awt.image.BufferedImage;

/**
 * Created by kevin.mcclusky on 5/31/2017.
 */
public class ScriptFunctions {
    public static String decodeBarcode(BufferedImage image) throws NotFoundException {
        BinaryBitmap bitmap = bufferedImageToBinaryBitmap(image);
        Result decodeResult = new MultiFormatReader().decode(bitmap);
        return decodeResult.getText();
    }

    private static BinaryBitmap bufferedImageToBinaryBitmap(BufferedImage image) {
        int[] pixels = image.getRGB(0, 0, image.getWidth(), image.getHeight(), null, 0, image.getWidth());
        RGBLuminanceSource source = new RGBLuminanceSource(image.getWidth(), image.getHeight(), pixels);
        BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
        return bitmap;
    }
}

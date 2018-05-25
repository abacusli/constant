package constant.tools.qrcode.util;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import javax.imageio.ImageIO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.Binarizer;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.EncodeHintType;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;

/**
 * 
 * @author abacus.li
 *
 */
public class QrCodeUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(QrCodeUtils.class);

    /**
     * 
     * @param text
     * @param outputStream
     * @author abacus.li
     * @throws IOException
     * @date 2017年8月28日
     *
     */
    public static void generateQrCode(String text, OutputStream outputStream) throws IOException {
        int width = 300;
        int height = 300;
        String format = "png";
        generateQrCode(text, width, height, format, outputStream);
    }

    /**
     * 
     * @param text
     * @param format
     * @param outputStream
     * @author abacus.li
     * @throws IOException
     * @date 2017年8月28日
     *
     */
    public static void generateQrCode(String text, String format, OutputStream outputStream) throws IOException {
        int width = 300;
        int height = 300;
        generateQrCode(text, width, height, format, outputStream);
    }

    public static void generateQrCode(String text, int width, int height, String format, OutputStream outputStream)
            throws IOException {
        Map<EncodeHintType, Object> hints = new Hashtable<EncodeHintType, Object>();
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
        BitMatrix bitMatrix;
        try {
            bitMatrix = new MultiFormatWriter().encode(text, BarcodeFormat.QR_CODE, width, height, hints);
            MatrixToImageWriter.writeToStream(bitMatrix, format, outputStream);
        } catch (WriterException e) {
            throw new IOException(e);
        } catch (IOException e) {
            throw e;
        } finally {
            if (null != outputStream) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    LOGGER.error(e.getMessage(), e);
                }
            }
        }
    }

    /**
     * 
     * @param input
     * @return
     * @author abacus.li
     * @throws IOException
     * @date 2017年8月28日
     *
     */
    public static String parseQrCode(InputStream input) throws IOException {
        try {
            BufferedImage image = ImageIO.read(input);
            LuminanceSource source = new BufferedImageLuminanceSource(image);
            Binarizer binarizer = new HybridBinarizer(source);
            BinaryBitmap binaryBitmap = new BinaryBitmap(binarizer);
            Map<DecodeHintType, Object> hints = new HashMap<DecodeHintType, Object>();
            hints.put(DecodeHintType.CHARACTER_SET, "UTF-8");
            MultiFormatReader formatReader = new MultiFormatReader();
            Result result;
            result = formatReader.decode(binaryBitmap, hints);
            return result.getText();
        } catch (NotFoundException e) {
            throw new IOException(e);
        } finally {
            if (null != input) {
                try {
                    input.close();
                } catch (IOException e) {
                    LOGGER.error(e.getMessage(), e);
                }
            }
        }
    }
}

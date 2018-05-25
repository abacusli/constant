package constant.tools.image.validation.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.imageio.ImageIO;

public class ValidationCode {

    public static final String VERIFY_CODES = "23456789ABCDEFGHJKLMNPQRSTUVWXYZabcdefghjklmnpqrstuvwxyz";

    /**
     * 获取随机颜色值
     * 
     * @param minColor
     * @param maxColor
     * @return
     */
    private static Color getRandomColor(int minColor, int maxColor) {

        Random random = new Random();
        // 保存minColor最大不会超过255
        if (minColor > 255)
            minColor = 255;
        // 保存minColor最大不会超过255
        if (maxColor > 255)
            maxColor = 255;
        // 获得红色的随机颜色值
        int red = minColor + random.nextInt(maxColor - minColor);
        // 获得绿色的随机颜色值
        int green = minColor + random.nextInt(maxColor - minColor);
        // 获得蓝色的随机颜色值
        int blue = minColor + random.nextInt(maxColor - minColor);
        return new Color(red, green, blue);

    }

    public static String getValidationCode(OutputStream outputStream) throws IOException {

        // 用于保存最后随机生成的验证码
        StringBuilder validationCode = new StringBuilder();
        try {
            // 设置图形验证码的长和宽（图形的大小）
            int width = 70;
            int height = 30;
            BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            Graphics g = image.getGraphics();// 获得用于输出文字的Graphics对象
            Random random = new Random();
            g.setColor(getRandomColor(180, 250));// 随机设置要填充的颜色
            g.fillRect(0, 0, width, height);// 填充图形背景
            // 设置初始字体
            g.setFont(new Font("Times New Roman", Font.ITALIC, height));
            g.setColor(getRandomColor(120, 180));// 随机设置字体颜色

            // 干扰线
            for (int i = 0; i < 155; i++) {
                int x = random.nextInt(width);
                int y = random.nextInt(height);
                int x1 = random.nextInt(width);
                int y1 = random.nextInt(height);
                g.drawLine(x, y, x + x1, y + y1);
            }

            // Random random = new Random();
            // 随机生成4个验证码
            for (int i = 0; i < 4; i++) {
                // 随机设置当前验证码的字符的字体
                // Constant.fonts[RandomUtil.getRandomInt(Constant.fonts.length
                // - 1)]
                g.setFont(new Font("Times New Roman", Font.ITALIC, height));
                // 随机获得当前验证码的字符串
                String code = VERIFY_CODES.charAt(random.nextInt(VERIFY_CODES.length())) + ""; /// Constant.srcStrings[RandomUtil.getRandomInt(61)];
                validationCode.append(code);
                // 随机设置当前验证码字符的颜色
                g.setColor(getRandomColor(10, 100));
                // 在图形上输出验证码字符，x和y都是随机生成的
                g.drawString(code, 16 * i + random.nextInt(7), height - random.nextInt(6));
            }
            // 名称重置

            ImageIO.write(image, "jpg", outputStream);

            g.dispose();

        } catch (IOException e) {
            throw e;
        }
        return validationCode.toString();
    }

}

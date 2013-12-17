package com.hr.rakus;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestCase extends TestBase {
    public static void main(String[] args) {
        //ブラウザ起動
        WebDriver driver = new FirefoxDriver();
        //Googleのトップページを開く
        driver.get("https://www.google.co.jp");
        sleep(1000);
        //検索
        WebElement text = driver.findElement(By.id("lst-ib"));
        text.sendKeys("selenium");
        sleep(1000);
        driver.findElement(By.name("btnK")).submit();
        sleep(1000);
        //URLをクリック
        driver.findElement(By.className("r")).click();
        sleep(1000);
        //想定通りのURLかチェック
        assertEquals(driver.getCurrentUrl(), "http://www.seleniumhq.org/");
        System.out.println(driver.getTitle());
        //スクリーンショット取得
        takeScreenShot(driver, "C:\\Users\\futeshi\\ci\\screenShot.png");
        //ブラウザを閉じる
        driver.quit();
    }

    public static void sleep(int microTime) {
        try {
            Thread.sleep(microTime);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void takeScreenShot(WebDriver driver, String filePath) {
        try {
            FileUtils.copyFile(
                    ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE),
                    new File(filePath));
        } catch (WebDriverException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

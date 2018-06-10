package pictureGallery;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class PictureGallery {
	private String imageDirStr = "images/";
	private String pageTitle = "My Image Gallery";
	private String titleBackground = "_banner.jpg";
	private int imagesRow = 4;

	private String pageInit;
	private String pageEnd;

	public PictureGallery(String imageDirStr, String pageTitle, String titleBackground, int imagesRow) {
		this.imageDirStr = imageDirStr;
		this.pageTitle = pageTitle;
		this.titleBackground = titleBackground;
		this.imagesRow = imagesRow;
	}

	private void initPage() {
		this.pageInit = "<!DOCTYPE html>\n" + "<html>\n" + "  <head>\n" +
		// ideally you wouldn't use inline CSS and put your CSS blocks here
				"    <title>Image Gallery</title>\n" + "  </head>\n" + "  <body>\n" + "    <center>\n"
				+ "        <div style=\"text-align: center;\n" + "            vertical-align: middle;\n"
				+ "            line-height: 100px;\n" + "            width: 90%;\n"
				+ "            background-image:url('" + imageDirStr + titleBackground + "');\">\n"
				+ "            <center style=\"color:#ffffff; font-size: 35px\">\n" + "              " + pageTitle
				+ "\n" + "            </center>\n" + "        </div>\n" + "        <br>\n"
				+ "  <table style=\"width:90%; font-family:'Verdana'; font-size: 10px \">\n";

		this.pageEnd = "  </table>\n" + "    </center>\n" + "  </body>\n" + "</html>";
	}

	public void buildPage() {
		initPage();

		StringBuilder webPage = new StringBuilder();
		webPage.append(pageInit);
		// all those other stuff inside the table and the table itself
		webPage.append(pageEnd);

		try (BufferedWriter bw = new BufferedWriter(new FileWriter("index.html"))) {
			bw.write(webPage.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		 PictureGallery pg = new PictureGallery("images/","My Image Gallery", "_banner.jpg",  4);
		pg.buildPage();
	}

}

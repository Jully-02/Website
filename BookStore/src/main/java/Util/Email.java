package Util;

import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Email {
	// Email: behaynhongnheo2@gmail.com
	// Password: ihcmfnxuynuefcqs

	static final String from = "behaynhongnheo2@gmail.com";
	static final String password = "ihcmfnxuynuefcqs";

	public static boolean sendEmail(String to, String title, String content) {
		// Properties: Khai bao cac thuoc tinh
		Properties props = new Properties();
		// SMTP HOST
		props.put("mail.smtp.host", "smtp.gmail.com");
		// TLS 587 SSL 465
		props.put("mail.smtp.port", "587");
		// Gui mail co can dang nhap khong? True
		props.put("mail.smtp.auth", "true");

		props.put("mail.smtp.starttls.enable", "true");

		// Create Authenticator
		Authenticator auth = new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
				return new PasswordAuthentication(from, password);
			}
		};

		// Create Session Work
		Session session = Session.getInstance(props, auth);

		// Send email
//		final String to = "nguyenducthiep16@gmail.com";

		// Create text msg
		MimeMessage msg = new MimeMessage(session);

		try {
			// Content type
			msg.addHeader("Content-type", "text/HTML; charset=UTF-8");

			// Sender
			msg.setFrom(from);

			// Receiver // to cc bcc
			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to, false));

			// Title email
			msg.setSubject(title);

			// Sent date
			msg.setSentDate(new Date());

			// Regulations on email receiving feedback
			// msg.setReplyTo(InternetAddress.parse(from, false));

			// Content
//			String content = "This is as a gift we want to thank our loyal customers. Have trusted and supported our store during the past time. We thank you and send a small gift to you!";
			msg.setContent(content, "text/html");

			// Send email
			Transport.send(msg);
			return true;
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public static void main(String[] args) {
		String to = "nguyenducthiep16@gmail.com";
		String title = "Order Status Email by Ulta Beauty";
		String content = "<!DOCTYPE html>\r\n"
				+ "<html>\r\n"
				+ "<head>\r\n"
				+ "\r\n"
				+ "<meta charset=\"utf-8\">\r\n"
				+ "<meta http-equiv=\"x-ua-compatible\" content=\"ie=edge\">\r\n"
				+ "<title>Email Confirmation</title>\r\n"
				+ "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n"
				+ "<style type=\"text/css\">\r\n"
				+ "/**\r\n"
				+ "   * Google webfonts. Recommended to include the .woff version for cross-client compatibility.\r\n"
				+ "   */\r\n"
				+ "@media screen {\r\n"
				+ "	@font-face {\r\n"
				+ "		font-family: 'Source Sans Pro';\r\n"
				+ "		font-style: normal;\r\n"
				+ "		font-weight: 400;\r\n"
				+ "		src: local('Source Sans Pro Regular'), local('SourceSansPro-Regular'),\r\n"
				+ "			url(https://fonts.gstatic.com/s/sourcesanspro/v10/ODelI1aHBYDBqgeIAH2zlBM0YzuT7MdOe03otPbuUS0.woff)\r\n"
				+ "			format('woff');\r\n"
				+ "	}\r\n"
				+ "	@font-face {\r\n"
				+ "		font-family: 'Source Sans Pro';\r\n"
				+ "		font-style: normal;\r\n"
				+ "		font-weight: 700;\r\n"
				+ "		src: local('Source Sans Pro Bold'), local('SourceSansPro-Bold'),\r\n"
				+ "			url(https://fonts.gstatic.com/s/sourcesanspro/v10/toadOcfmlt9b38dHJxOBGFkQc6VGVFSmCnC_l7QZG60.woff)\r\n"
				+ "			format('woff');\r\n"
				+ "	}\r\n"
				+ "}\r\n"
				+ "/**\r\n"
				+ "   * Avoid browser level font resizing.\r\n"
				+ "   * 1. Windows Mobile\r\n"
				+ "   * 2. iOS / OSX\r\n"
				+ "   */\r\n"
				+ "body, table, td, a {\r\n"
				+ "	-ms-text-size-adjust: 100%; /* 1 */\r\n"
				+ "	-webkit-text-size-adjust: 100%; /* 2 */\r\n"
				+ "}\r\n"
				+ "/**\r\n"
				+ "   * Remove extra space added to tables and cells in Outlook.\r\n"
				+ "   */\r\n"
				+ "table, td {\r\n"
				+ "	mso-table-rspace: 0pt;\r\n"
				+ "	mso-table-lspace: 0pt;\r\n"
				+ "}\r\n"
				+ "/**\r\n"
				+ "   * Better fluid images in Internet Explorer.\r\n"
				+ "   */\r\n"
				+ "img {\r\n"
				+ "	-ms-interpolation-mode: bicubic;\r\n"
				+ "}\r\n"
				+ "/**\r\n"
				+ "   * Remove blue links for iOS devices.\r\n"
				+ "   */\r\n"
				+ "a[x-apple-data-detectors] {\r\n"
				+ "	font-family: inherit !important;\r\n"
				+ "	font-size: inherit !important;\r\n"
				+ "	font-weight: inherit !important;\r\n"
				+ "	line-height: inherit !important;\r\n"
				+ "	color: inherit !important;\r\n"
				+ "	text-decoration: none !important;\r\n"
				+ "}\r\n"
				+ "/**\r\n"
				+ "   * Fix centering issues in Android 4.4.\r\n"
				+ "   */\r\n"
				+ "div[style*=\"margin: 16px 0;\"] {\r\n"
				+ "	margin: 0 !important;\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ "body {\r\n"
				+ "	width: 100% !important;\r\n"
				+ "	height: 100% !important;\r\n"
				+ "	padding: 0 !important;\r\n"
				+ "	margin: 0 !important;\r\n"
				+ "}\r\n"
				+ "/**\r\n"
				+ "   * Collapse table borders to avoid space between cells.\r\n"
				+ "   */\r\n"
				+ "table {\r\n"
				+ "	border-collapse: collapse !important;\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ "a {\r\n"
				+ "	color: #1a82e2;\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ "img {\r\n"
				+ "	height: auto;\r\n"
				+ "	line-height: 100%;\r\n"
				+ "	text-decoration: none;\r\n"
				+ "	border: 0;\r\n"
				+ "	outline: none;\r\n"
				+ "}\r\n"
				+ "</style>\r\n"
				+ "\r\n"
				+ "<link\r\n"
				+ "	href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css\"\r\n"
				+ "	rel=\"stylesheet\"\r\n"
				+ "	integrity=\"sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM\"\r\n"
				+ "	crossorigin=\"anonymous\">\r\n"
				+ "<link rel=\"icon\" type=\"image/png\" href=\"Image/Logo/GigiandJullyLogo.png\">\r\n"
				+ "<link rel=\"stylesheet\" type=\"text/css\" href=\"CSS/style.css\">\r\n"
				+ "<script\r\n"
				+ "	src=\"https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js\"\r\n"
				+ "	integrity=\"sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r\"\r\n"
				+ "	crossorigin=\"anonymous\"></script>\r\n"
				+ "<script\r\n"
				+ "	src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js\"\r\n"
				+ "	integrity=\"sha384-fbbOQedDUMZZ5KreZpsbe1LCZPVmfTnH7ois6mU1QK+m14rQ1l2bGBq41eYeM/fS\"\r\n"
				+ "	crossorigin=\"anonymous\"></script>\r\n"
				+ "\r\n"
				+ "</head>\r\n"
				+ "<body style=\"background-color: #e9ecef;\">\r\n"
				+ "\r\n"
				+ "	<!-- start preheader -->\r\n"
				+ "	<div class=\"preheader\"\r\n"
				+ "		style=\"display: none; max-width: 0; max-height: 0; overflow: hidden; font-size: 1px; line-height: 1px; color: #fff; opacity: 0;\">\r\n"
				+ "		A preheader is the short summary text that follows the subject line\r\n"
				+ "		when an email is viewed in the inbox.</div>\r\n"
				+ "	<!-- end preheader -->\r\n"
				+ "\r\n"
				+ "	<!-- start body -->\r\n"
				+ "	<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\r\n"
				+ "\r\n"
				+ "		<!-- start logo -->\r\n"
				+ "		<tr>\r\n"
				+ "			<td align=\"center\" bgcolor=\"#e9ecef\">\r\n"
				+ "				<!--[if (gte mso 9)|(IE)]>\r\n"
				+ "        <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"600\">\r\n"
				+ "        <tr>\r\n"
				+ "        <td align=\"center\" valign=\"top\" width=\"600\">\r\n"
				+ "        <![endif]-->\r\n"
				+ "\r\n"
				+ "					 <img src=\"C:\\Sophomore\\Web\\BookStore\\src\\main\\webapp\\Image\\Logo\\GigiandJullyLogo1.png\" alt=\"Logo\" border=\"0\" width=\"48\" tyle=\"display: block; width: 48px; max-width: 48px; min-width: 48px;\">\r\n"
				+ "				\r\n"
				+ " <!--[if (gte mso 9)|(IE)]>\r\n"
				+ "        </td>\r\n"
				+ "        </tr>\r\n"
				+ "        </table>\r\n"
				+ "        <![endif]-->\r\n"
				+ "			</td>\r\n"
				+ "		</tr>\r\n"
				+ "		<!-- end logo -->\r\n"
				+ "\r\n"
				+ "		<!-- start hero -->\r\n"
				+ "		<tr>\r\n"
				+ "			<td align=\"center\" bgcolor=\"#e9ecef\">\r\n"
				+ "				<!--[if (gte mso 9)|(IE)]>\r\n"
				+ "        <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"600\">\r\n"
				+ "        <tr>\r\n"
				+ "        <td align=\"center\" valign=\"top\" width=\"600\">\r\n"
				+ "        <![endif]-->\r\n"
				+ "				<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\"\r\n"
				+ "					style=\"max-width: 600px;\">\r\n"
				+ "					<tr>\r\n"
				+ "						<td align=\"left\" bgcolor=\"#ffffff\"\r\n"
				+ "							style=\"padding: 36px 24px 0; font-family: 'Source Sans Pro', Helvetica, Arial, sans-serif; border-top: 3px solid #d4dadf;\">\r\n"
				+ "							<h1\r\n"
				+ "								style=\"margin: 0; font-size: 32px; font-weight: 700; letter-spacing: -1px; line-height: 48px;\">Confirm\r\n"
				+ "								Your Email Address</h1>\r\n"
				+ "						</td>\r\n"
				+ "					</tr>\r\n"
				+ "				</table> <!--[if (gte mso 9)|(IE)]>\r\n"
				+ "        </td>\r\n"
				+ "        </tr>\r\n"
				+ "        </table>\r\n"
				+ "        <![endif]-->\r\n"
				+ "			</td>\r\n"
				+ "		</tr>\r\n"
				+ "		<!-- end hero -->\r\n"
				+ "\r\n"
				+ "		<!-- start copy block -->\r\n"
				+ "		<tr>\r\n"
				+ "			<td align=\"center\" bgcolor=\"#e9ecef\">\r\n"
				+ "				<!--[if (gte mso 9)|(IE)]>\r\n"
				+ "        <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"600\">\r\n"
				+ "        <tr>\r\n"
				+ "        <td align=\"center\" valign=\"top\" width=\"600\">\r\n"
				+ "        <![endif]-->\r\n"
				+ "				<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\"\r\n"
				+ "					style=\"max-width: 600px;\">\r\n"
				+ "\r\n"
				+ "					<!-- start copy -->\r\n"
				+ "					<tr>\r\n"
				+ "						<td align=\"left\" bgcolor=\"#ffffff\"\r\n"
				+ "							style=\"padding: 24px; font-family: 'Source Sans Pro', Helvetica, Arial, sans-serif; font-size: 16px; line-height: 24px;\">\r\n"
				+ "							<p style=\"margin: 0;\">\r\n"
				+ "								Tap the button below to confirm your email address. If you\r\n"
				+ "								didn't create an account with <a\r\n"
				+ "									href=\"https://www.facebook.com/DucThiep02\">Paste</a>, you can\r\n"
				+ "								safely delete this email.\r\n"
				+ "							</p>\r\n"
				+ "						</td>\r\n"
				+ "					</tr>\r\n"
				+ "					<!-- end copy -->\r\n"
				+ "\r\n"
				+ "					<!-- start button -->\r\n"
				+ "					<tr>\r\n"
				+ "						<td align=\"left\" bgcolor=\"#ffffff\">\r\n"
				+ "							<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\r\n"
				+ "								<tr>\r\n"
				+ "									<td align=\"center\" bgcolor=\"#ffffff\" style=\"padding: 12px;\">\r\n"
				+ "										<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\r\n"
				+ "											<tr>\r\n"
				+ "												<td align=\"center\" bgcolor=\"#1a82e2\"\r\n"
				+ "													style=\"border-radius: 6px;\"><a\r\n"
				+ "													href=\"https://www.facebook.com/DucThiep02\" target=\"_blank\"\r\n"
				+ "													style=\"display: inline-block; padding: 16px 36px; font-family: 'Source Sans Pro', Helvetica, Arial, sans-serif; font-size: 16px; color: #ffffff; text-decoration: none; border-radius: 6px;\">Do\r\n"
				+ "														Something Sweet</a></td>\r\n"
				+ "											</tr>\r\n"
				+ "										</table>\r\n"
				+ "									</td>\r\n"
				+ "								</tr>\r\n"
				+ "							</table>\r\n"
				+ "						</td>\r\n"
				+ "					</tr>\r\n"
				+ "					<!-- end button -->\r\n"
				+ "\r\n"
				+ "					<!-- start copy -->\r\n"
				+ "					<tr>\r\n"
				+ "						<td align=\"left\" bgcolor=\"#ffffff\"\r\n"
				+ "							style=\"padding: 24px; font-family: 'Source Sans Pro', Helvetica, Arial, sans-serif; font-size: 16px; line-height: 24px;\">\r\n"
				+ "							<p style=\"margin: 0;\">If that doesn't work, copy and paste\r\n"
				+ "								the following link in your browser:</p> \r\n"
				+ "							<i><svg\r\n"
				+ "								xmlns=\"http://www.w3.org/2000/svg\" width=\"16\" height=\"16\"\r\n"
				+ "								fill=\"currentColor\" class=\"bi bi-facebook\" viewBox=\"0 0 16 16\">\r\n"
				+ "  <path\r\n"
				+ "									d=\"M16 8.049c0-4.446-3.582-8.05-8-8.05C3.58 0-.002 3.603-.002 8.05c0 4.017 2.926 7.347 6.75 7.951v-5.625h-2.03V8.05H6.75V6.275c0-2.017 1.195-3.131 3.022-3.131.876 0 1.791.157 1.791.157v1.98h-1.009c-.993 0-1.303.621-1.303 1.258v1.51h2.218l-.354 2.326H9.25V16c3.824-.604 6.75-3.934 6.75-7.951z\" />\r\n"
				+ "</svg></i>\r\n"
				+ "							<p style=\"margin: 0;\">\r\n"
				+ "								<a href=\"https://www.facebook.com/DucThiep02\" target=\"_blank\" style=\"text-decoration: none;\">Facebook</a>\r\n"
				+ "							</p> \r\n"
				+ "							<i><svg xmlns=\"http://www.w3.org/2000/svg\" width=\"16\" height=\"16\"\r\n"
				+ "								fill=\"currentColor\" class=\"bi bi-telephone\" viewBox=\"0 0 16 16\">\r\n"
				+ "  <path\r\n"
				+ "									d=\"M3.654 1.328a.678.678 0 0 0-1.015-.063L1.605 2.3c-.483.484-.661 1.169-.45 1.77a17.568 17.568 0 0 0 4.168 6.608 17.569 17.569 0 0 0 6.608 4.168c.601.211 1.286.033 1.77-.45l1.034-1.034a.678.678 0 0 0-.063-1.015l-2.307-1.794a.678.678 0 0 0-.58-.122l-2.19.547a1.745 1.745 0 0 1-1.657-.459L5.482 8.062a1.745 1.745 0 0 1-.46-1.657l.548-2.19a.678.678 0 0 0-.122-.58L3.654 1.328zM1.884.511a1.745 1.745 0 0 1 2.612.163L6.29 2.98c.329.423.445.974.315 1.494l-.547 2.19a.678.678 0 0 0 .178.643l2.457 2.457a.678.678 0 0 0 .644.178l2.189-.547a1.745 1.745 0 0 1 1.494.315l2.306 1.794c.829.645.905 1.87.163 2.611l-1.034 1.034c-.74.74-1.846 1.065-2.877.702a18.634 18.634 0 0 1-7.01-4.42 18.634 18.634 0 0 1-4.42-7.009c-.362-1.03-.037-2.137.703-2.877L1.885.511z\" />\r\n"
				+ "</svg></i>\r\n"
				+ "							<p style=\"margin: 0;\">\r\n"
				+ "								<a href=\"https://www.instagram.com/02_.jully/\" target=\"_blank\" style=\"text-decoration: none;\">Instagram</a>\r\n"
				+ "							</p>\r\n"
				+ "						</td>\r\n"
				+ "					</tr>\r\n"
				+ "					<!-- end copy -->\r\n"
				+ "\r\n"
				+ "					<!-- start copy -->\r\n"
				+ "					<tr>\r\n"
				+ "						<td align=\"left\" bgcolor=\"#ffffff\"\r\n"
				+ "							style=\"padding: 24px; font-family: 'Source Sans Pro', Helvetica, Arial, sans-serif; font-size: 16px; line-height: 24px; border-bottom: 3px solid #d4dadf\">\r\n"
				+ "							<p style=\"margin: 0;\">\r\n"
				+ "								Cheers,<br> Paste\r\n"
				+ "							</p>\r\n"
				+ "						</td>\r\n"
				+ "					</tr>\r\n"
				+ "					<!-- end copy -->\r\n"
				+ "\r\n"
				+ "				</table> <!--[if (gte mso 9)|(IE)]>\r\n"
				+ "        </td>\r\n"
				+ "        </tr>\r\n"
				+ "        </table>\r\n"
				+ "        <![endif]-->\r\n"
				+ "			</td>\r\n"
				+ "		</tr>\r\n"
				+ "		<!-- end copy block -->\r\n"
				+ "\r\n"
				+ "		<!-- start footer -->\r\n"
				+ "		<tr>\r\n"
				+ "			<td align=\"center\" bgcolor=\"#e9ecef\" style=\"padding: 24px;\">\r\n"
				+ "				<!--[if (gte mso 9)|(IE)]>\r\n"
				+ "        <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"600\">\r\n"
				+ "        <tr>\r\n"
				+ "        <td align=\"center\" valign=\"top\" width=\"600\">\r\n"
				+ "        <![endif]-->\r\n"
				+ "				<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\"\r\n"
				+ "					style=\"max-width: 600px;\">\r\n"
				+ "\r\n"
				+ "					<!-- start permission -->\r\n"
				+ "					<tr>\r\n"
				+ "						<td align=\"center\" bgcolor=\"#e9ecef\"\r\n"
				+ "							style=\"padding: 12px 24px; font-family: 'Source Sans Pro', Helvetica, Arial, sans-serif; font-size: 14px; line-height: 20px; color: #666;\">\r\n"
				+ "							<p style=\"margin: 0;\">You received this email because we\r\n"
				+ "								received a request for [type_of_action] for your account. If you\r\n"
				+ "								didn't request [type_of_action] you can safely delete this\r\n"
				+ "								email.</p>\r\n"
				+ "						</td>\r\n"
				+ "					</tr>\r\n"
				+ "					<!-- end permission -->\r\n"
				+ "\r\n"
				+ "					<!-- start unsubscribe -->\r\n"
				+ "					<tr>\r\n"
				+ "						<td align=\"center\" bgcolor=\"#e9ecef\"\r\n"
				+ "							style=\"padding: 12px 24px; font-family: 'Source Sans Pro', Helvetica, Arial, sans-serif; font-size: 14px; line-height: 20px; color: #666;\">\r\n"
				+ "							<p style=\"margin: 0;\">\r\n"
				+ "								To stop receiving these emails, you can <a\r\n"
				+ "									href=\"https://www.facebook.com/DucThiep02\" target=\"_blank\">unsubscribe</a>\r\n"
				+ "								at any time.\r\n"
				+ "							</p>\r\n"
				+ "							<p style=\"margin: 0;\">Paste 1234 S. Broadway St. City, State\r\n"
				+ "								12345</p>\r\n"
				+ "						</td>\r\n"
				+ "					</tr>\r\n"
				+ "					<!-- end unsubscribe -->\r\n"
				+ "\r\n"
				+ "				</table> <!--[if (gte mso 9)|(IE)]>\r\n"
				+ "        </td>\r\n"
				+ "        </tr>\r\n"
				+ "        </table>\r\n"
				+ "        <![endif]-->\r\n"
				+ "			</td>\r\n"
				+ "		</tr>\r\n"
				+ "		<!-- end footer -->\r\n"
				+ "\r\n"
				+ "	</table>\r\n"
				+ "	<!-- end body -->\r\n"
				+ "\r\n"
				+ "</body>\r\n"
				+ "</html>";
		Email.sendEmail(to, title, content);
	}
}

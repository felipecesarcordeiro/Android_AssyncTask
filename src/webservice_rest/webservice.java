/*Felipe César Cordeiro Campelo
 * Matricula : 20121004010 
 * 4°ano Integrado em informatica
 * github:felipecesarcordeiro e-mail:felipecesarcordeiro@gmail.com*/

package webservice_rest;

import java.io.*;
import javaz.servlet.*;
import java security.*;
import java.util.Date;
import org.json.JSONObject;

/**
 * Servlet implementation class webservice
 */
@WebServlet("/webservice")
public class webservice extends HttpServlet 
	{
		private static final long serialVersionUID = 1L;
       
		/**
		 * @see HttpServlet#HttpServlet()
		 */
		
		public webservice() 
		{
			super();
			// TODO Auto-generated constructor stub
		}

		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
		 */

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
		{
			// TODO Auto-generated method stub
			doGet(request, response);
			
			StringBuffer stringBuffer = new StringBuffer();
			String line = null;

			// Leitura do conteúdo do pacote da requisição HTTP.
			BufferedReader reader = request.getReader();
			
			while ((line = reader.readLine()) != null) 
			{
				stringBuffer.append(line);
			}
				
			// Conversão para JSONObject
			JSONObject json = new JSONObject(stringBuffer.toString());
			
			String nome = json.getString("nome");
			String senha = json.getString("senha");		

			PrintWriter pw = response.getWriter();
			
			if (nome.toLowerCase().trim().equals(nome) && senha.trim().equals(senha)) 
			{			
				
				try 
				{
					pw.write("{'key': '" + criptografarSha256("IFPB") + "'}");
					response.setStatus(200);
					
				} 
				catch (NoSuchAlgorithmException e) 
				{
					e.printStackTrace();
				}			
				
			} 
			else 
			{
				response.setStatus(500);
				pw.write("{'mensagem': 'Username e Senha não correspondem'}");
			}	

			pw.close();
		}
		
		public static String criptografarSha256(String valorPlano)throws NoSuchAlgorithmException, UnsupportedEncodingException 
		{

			MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
			byte messageDigest[] = algorithm.digest(valorPlano.getBytes("UTF-8"));

			StringBuilder hexString = new StringBuilder();

			for (byte b : messageDigest) 
			{
				hexString.append(String.format("%02X", 0xFF & b));
			}

			String senha = hexString.toString();

			return senha;
		}

	}



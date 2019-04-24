package mpAccount;


	
	
	import java.util.Random;

	public class  mpAccountTestData {


		private static String MissionPartnerAccount = "";

		
		
		public static String getMissionPartnerAccount() {

			if (MissionPartnerAccount.equals("")) {

				String MyString = "Mission Partner Acccount ";
				Random rand = new Random();
				int num = rand.nextInt(1000) + 1;
				setMissionPartnerAccount(MyString + num);

			}

			return MissionPartnerAccount;

		}

		public static void setMissionPartnerAccount(String newMissionPartnerAccount) {

			MissionPartnerAccount = newMissionPartnerAccount;

		}
		
		
		

		
	}

	
	
	




public class TestClass {
	public static int diceThrow(int min ,int max){
		int range = (max - min) + 1;     
		return (int)(Math.random() * range) + min;		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String[] testData = "i.like.this.program.very.much".split(".");
//		for(int i =0; i < testData.length ; i ++){
//			System.out.println(testData[i]);
//		}
		for(int i=0;i<6; i++){
			System.out.println(diceThrow(1, 6));
		}
		System.out.println((int)(Math.random()*6+1));
	}

}

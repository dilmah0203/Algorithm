package BF;

class 숫자문자열과영단어 {
    public int solution(String s) {
        
    	//영단어를 담는 String 타입의 배열 생성
    	//영단어와 배열의 인덱스값이 동일하다.
        String[] array = {"zero","one","two","three","four","five","six","seven","eight","nine"};
        
        //반복문을 사용해 배열 안의 모든 영단어를 검사한다.
        //문자열 s에 영단어가 있다면 replace를 사용해 변환한다.
        for(int i = 0; i < array.length ; i++) {
        	if(s.contains(array[i])) {
        		s = s.replace(array[i], String.valueOf(i));
        	}
        }
        return Integer.parseInt(s);
    }
}

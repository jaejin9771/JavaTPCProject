import java.io.InputStream;
import org.json.*;

public class Project01_C {

	public static void main(String[] args) {
		String src="info.json"; //클래스가 있는 디렉토리 안에서 파일을 찾음
		// IO->Stream(스트림)
		InputStream is = Project01_C.class.getResourceAsStream(src); //경로 지정
		if(is==null) {
			throw new NullPointerException("Cannot find resource file");
		}
		JSONTokener tokener = new JSONTokener(is);
		JSONObject object = new JSONObject(tokener);
		JSONArray students = object.getJSONArray("students");
		for(int i=0; i<students.length(); i++) {
			JSONObject student = (JSONObject)students.get(i);
			System.out.print(student.get("name") + "\t");
			System.out.print(student.get("address") + "\t");
			System.out.println(student.get("phone") + "\t");
		}
	}

}

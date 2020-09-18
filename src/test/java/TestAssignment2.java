import com.main.assigment2.ConstantsDeclaration;
import com.main.assigment2.FileCopyFromOneFolderToAnother;
import java.io.IOException;

public class TestAssignment2 {
    public static void main(String args[]) throws IOException {
        FileCopyFromOneFolderToAnother fp=new FileCopyFromOneFolderToAnother();
        ConstantsDeclaration.MODEL_PATH="/Users/sukumar/Desktop/Apptio Important/Other/OnlineCodingAssignment/SoftwareAGAssignment/Resource/merge/model";
        ConstantsDeclaration.SRC_PATH="/Users/sukumar/Desktop/Apptio Important/Other/OnlineCodingAssignment/SoftwareAGAssignment/Resource/merge/source";
        fp.copyAlltheFilesFromSrcToDest();
    }
}

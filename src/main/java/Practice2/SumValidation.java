package Practice2;

import io.restassured.path.json.JsonPath;
import org.junit.Assert;
import org.junit.Test;
import sun.util.resources.cldr.am.CalendarData_am_ET;

public class SumValidation
{
    // trying to do this otherway then running in main methis psvm

    @Test

    public void sumOfCourses()
    {
        int sum = 0; //created one sum addtion method to use in our sum up in last
        JsonPath jsonPath = new JsonPath(ReturnMethod.CoursePrice());
        int count =jsonPath.getInt("courses.size()"); // need to create a count bfore we start for loop

        for(int i=0; i< count;i++)
        {
           int Prices =  jsonPath.get("courses["+i+"].price");
           int Copies =  jsonPath.get("courses["+i+"].copies");
           int Amount = Prices*Copies;
            System.out.println(Amount);
            sum = sum + Amount;
        }
        System.out.println("Total Purchase Amount is: "+sum);
        int purAmount = jsonPath.get("dashboard.purchaseAmount");


        Assert.assertEquals(sum,purAmount);
    }

}

package Practice2;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.junit.Assert;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PassComplexJson
{



    public static void main(String[] args)
    {// we create a complex json path to like we have arrays of object to be pass in one Api
        // so first we will creat qa object of Jsonpath

        JsonPath jsonPath = new JsonPath(ReturnMethod.CoursePrice());

        // we don't have nay thing to as no ApI is been ready yet
        // so let try to mock this and try to solve it

        /* 1. Print No of courses returned by API */

        int count =jsonPath.getInt("courses.size()"); //size is in-build to mention array in json

        System.out.println(count); // this will give us count of courses which is array 1. which is 3

        /* 2.Print Purchase Amount */

    //purchase amt lies in dashboard
       int totalAmt =  jsonPath.getInt("dashboard.purchaseAmount");
        System.out.println(totalAmt); // tis will print the total amt of purchase 910 in console.

        /* 3. Print Title of the first course */
        // need to do with array as its lies in array [0]
        String titleCourse = jsonPath.get("courses[2].title"); // get can pull up string can use getString too
        System.out.println(titleCourse);

        /* 4. Print All course titles and their respective Prices */
        // if we have more courses sometime can have 1 so this courses is dynamic
        // we can use simple for loop to solve this

        for(int i=0 ; i<count; i++)
        {
            String courseTitle = jsonPath.get("courses["+i+"].title");
            System.out.println("title: " +courseTitle);
            //adding prices to each course too

            int Prices = jsonPath.get("courses["+i+"].price");
            System.out.println("prices: "+Prices);
        }


        /* 5. Print no of copies sold by RPA Course */
        // today its in 2nd index tommorw it may e in different index so need to scan each and every element of

        for(int i=0 ; i<count; i++)
        {
            String courseTitle = jsonPath.get("courses["+i+"].title");
            System.out.println("title: " +courseTitle);

            if (courseTitle.equalsIgnoreCase("RPA"))
            {
                //copies sold
                int Copies = jsonPath.get("courses["+i+"].copies");
                System.out.println("No. of copies sold by RPA Course: " +Copies);
                // we mention break to stop for loop to run further after getting answer.
                break;
            }
        }


        /* 6. Verify if Sum of all Course prices matches with Purchase Amount */

       // created a new class for this














    }

}

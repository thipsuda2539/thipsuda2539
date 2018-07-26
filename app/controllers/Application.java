package controllers;

import models.Puppy;
import play.*;
import play.api.templates.Html;
import play.data.DynamicForm;
import play.data.Form;
import play.mvc.*;
import models.addproduct;
import scala.Dynamic;
import scala.Int;
import scala.math.Ordering;
import views.html.*;



public class Application extends Controller {
    public static Result main(Html content) {
        return ok(main.render(content));
    }

    public static Result index() {
        return main(Products.render());
    }

    public static Result promotion() {
        return main(Promotion.render());
    }


    public static Result puppy(){
       Puppy Beagle=new Puppy("P001","Beagle",4900.00,300);
        Puppy  Golden_Retriever=new Puppy ("P002","Golden Retriever",6500.00, 200);
        Puppy Westie_Terrier=new Puppy  ("P003","Westie Terrier",35000.00,100);
        Puppy Poodle =new Puppy("P004","Poodle",4800.00,100);
        Puppy Maltese =new Puppy("P005","Maltese",28000.00,70);
        Puppy Chow_Chow =new Puppy ("P005","Chow Chow",22000.00,150);{
            return main(puppy.render(Beagle,Golden_Retriever,Westie_Terrier,Poodle,Maltese,Chow_Chow));
        }
}
    public static Result inputproduct(){
        return main(from.render());
    }
    public static Result showproduct(){
        DynamicForm input= Form.form().bindFromRequest();
         String id,name;
         double price;
         int amount;

         id=input.get("id");
         name=input.get("name");
         price=Double.parseDouble(input.get("price"));
         amount=Integer.parseInt(input.get("amount"));

         addproduct output =new addproduct(id,name,price,amount);

        return main(showfrom.render(output));
    }
}


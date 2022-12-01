public class Cat {
   private String name = "金渐层";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private void hi(){
       System.out.println("hi"+name);
   }

   private void cry(){
       System.out.println("喵喵喵...");
   }
}

package basic;
class Student {
    private String name;
    private String number;
    private String age;
    private Float jidian;
    public Student()
    { }//每一个Java类都要有构造函数，如果没有，编译器会自动加上构造函数,so.......
    public Student(String name, String stdId, String age, float jidian) {
        super();
        this.name = name;
        this.number = stdId;
        this.age = age;
        this.jidian = jidian;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getNumber()
    {
        return number;
    }

    public void setNumber(String stdId)
    {
        this.number = stdId;
    }

    public String getAge()
    {
        return age;
    }

    public void setAge(String age)
    {
        this.age = age;
    }

    public float getJidian()
    {
        return jidian;
    }

    public void setJidian(float jidian)
    {
        this.jidian = jidian;
    }
}
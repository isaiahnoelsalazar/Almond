# Note: This dependency is deprecated and is obsolete. It now exists for archival purposes only.
# How to use Almond
- Add JitPack in settings.gradle
```
repositories {
    /* other existing code */
    maven { url 'https://jitpack.io' }
}
```
- Add dependency in build.gradle
```
implementation 'com.github.saiaaaaaaa:Almond:(version)'
```
## Sample applications using Almond
- https://github.com/saiaaaaaaa/Note
# Available customs
## 1. SimpleList
- Create RecyclerView in activity layout
```
<androidx.recyclerview.widget.RecyclerView
    android:id="@+id/rv"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:overScrollMode="never"
    app:layout_constraintTop_toTopOf="parent" />
```
- Create reference to RecyclerView and desired data in activity class
```
List<String> data = new ArrayList<>();
/* data.add("Sample text"); */
RecyclerView rv = findViewById(R.id.rv);
```
- Initialize SimpleList using context, RecyclerView reference, and data reference
```
SimpleList simpleList = new SimpleList(context, rv, data); // simple list
```
#### *Other initialization methods*
- SimpleList with item click
```
public class MyClass extends AppCompatAcitivty implements SimpleListOnItemClick {
    /* other existing code */
    SimpleList simpleList = new SimpleList(context, rv, data, this);
}
```
- SimpleList with item long click
```
public class MyClass extends AppCompatAcitivty implements SimpleListOnItemLongClick {
    /* other existing code */
    SimpleList simpleList = new SimpleList(context, rv, data, this);
}
```
- SimpleList with item click and item long click
```
public class MyClass extends AppCompatAcitivty implements SimpleListOnItemClick, SimpleListOnItemLongClick {
    /* other existing code */
    SimpleList simpleList = new SimpleList(context, rv, data, this, this);
}
```
> Keyword 'this' refers to implementation SimpleListOnItemClick and/or SimpleListOnItemLongClick
#### Methods
- Add data to SimpleList
```
simpleList.addItem("Sample text");
```
- Remove data from SimpleList
```
simpleList.removeItem(0); // index of item

simpleList.removeStartItem(); //removes item at the start of the list

simpleList.removeEndItem(); // removes item at the end of the list
```
- Get List<String> data from SimpleList
```
simpleList.getData(); // returns List<String>
```
- Set simple list item padding
```
simpleList.setItemPadding(16); // will set 16dp padding to left, top, right, bottom
// or
simpleList.setItemPadding(16, 22, 24, 8); // will set multiple padding values to left, top, right, bottom
```
## 2. RoundedAlertDialog
- Initialize RoundedAlertDialog using context
```
RoundedAlertDialog rad = new RoundedAlertDialog(context); // rounded alert dialog
rad.create("Title"); // required

rad.show(); // shows rounded alert dialog
```
#### Methods
- Working with left and/or right button/s
```
rad.setupRightButton("Sample text"); // show right button

rad.setupRightButtonOnClick(new View.OnClickListener() { // add right button click listener
    @Override
    public void onClick(View v) {
        /* code */
    }
});

rad.setupLeftButton("Sample text"); // show left button

rad.setupLeftButtonOnClick(new View.OnClickListener() { // add left button click listener
    @Override
    public void onClick(View v) {
        /* code */
    }
});
```
#### *Adding a view to RoundedAlertDialog*
- Create a custom XML layout file
```
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <DatePicker
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:spinnersShown="false"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

</androidx.constraintlayout.widget.ConstraintLayout>
```
> Sample code above is only an example for a custom XML layout. Feel free to create any layout you want.
- Initialize custom XML layout file and add to RoundedAlertDialog
```
LayoutInflater li = LayoutInflater.from(this);
View v = li.inflate(R.layout.custom_layout, null);

/* other existing code */

rad.addView(v);
```
> Don't forget to call 'rad.show()' method
## 3. StringChecker
#### Methods
- Check a string if it has any symbols
```
StringChecker.hasSymbols("Sample text"); // returns false

StringChecker.hasSymbols("Sample text!"); // returns true
```
- Check a string if it has any numbers
```
StringChecker.hasNumbers("Sample text"); // returns false

StringChecker.hasNumbers("Sample text 1"); // returns true
```
## 4. EasySQL
- Initialize EasySQL using context
```
EasySQL es = new EasySQL(context);
```
#### Methods
- Create a table
```
Map<String, String> columns = new HashMap<>();
testvalues1.put("fname", "text");
testvalues1.put("lname", "text");

es.createTable("db1", "table1", columns);
```
> EasySQL will automatically create/open a database while calling the 'createTable' method
- Check if a table exists
```
if (!es.doesTableExist("db1", "table1")){
    /* other existing code */
}
```
- Insert a value to a table
```
Map<String, String> values = new HashMap<>();
testvalues1.put("fname", "Nutty");
testvalues1.put("lname", "Almond");

es.createTable("db1", "table1", values);
```
- Get all values from a table
```
List<Map<String, String>> tableValues = es.getTableValues("db1", "table1");
```
- Delete a table
```
es.deleteTable("db1", "table1");
```
- Delete a value from a table
```
String whereClause = es.whereClauseCreator("fname", "Nutty");
es.deleteFromTable("db1", "table1", whereClause);
```
## 5. Fullscreen
- Enable fullscreen on any activity
```
Fullscreen.enableFullscreen(this);
```
> Keyword 'this' refers to any valid activity
- Disable fullscreen on any activity
```
Fullscreen.disableFullscreen(this);
```
> Keyword 'this' refers to any valid activity

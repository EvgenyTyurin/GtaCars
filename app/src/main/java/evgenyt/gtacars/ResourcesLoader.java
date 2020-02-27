package evgenyt.gtacars;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Load data from resources
 */

public class ResourcesLoader {

    private static ResourcesLoader loader;
    private static Resources resources;
    private static String packageName;

    private ResourcesLoader(Context context) {
        resources = context.getResources();
        packageName = context.getPackageName();
    }

    public static ResourcesLoader getInstance(Context context) {
        loader = new ResourcesLoader(context);
        return loader;
    }

    public static ResourcesLoader getInstance() {
        return loader;
    }

    public static String getImgName(String item) {
        String result = item.toLowerCase();
        result = result.replaceAll(" ", "_");
        result = result.replaceAll("-", "_");
        return result;
    }

    /** @return String array from string-array object in strings.xml */
    public ArrayList<String> getStringArray(String resourceName) {
        ArrayList<String> arrayList = new ArrayList<>();
        int resourceID = resources.
                getIdentifier(resourceName, "array", packageName);
        if (resourceID != 0)
            arrayList =new ArrayList<>(Arrays.asList(resources
                    .getStringArray(resourceID)));
        return arrayList;
    }

    /** Returns image drawable object by image name */
    public Drawable getImgByName(String imgName) {
        if (imgName.equals("")) {
            String uri = "@android:drawable/list_selector_background";
            int imageResource = resources.getIdentifier(uri, null,
                    packageName);
            return resources.getDrawable(imageResource);
        } else {
            String uri = "@drawable/" + imgName;
            int imageResource = resources.getIdentifier(uri, null,
                    packageName);
            if (imageResource > 0) {
                return  resources.getDrawable(imageResource);
            }
            else {
                return getImgByName("");
            }
        }
    }

}

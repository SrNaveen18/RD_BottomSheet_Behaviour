package com.example.naveen.designprt.profile;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.example.naveen.designprt.R;
import com.example.naveen.designprt.googlemap.ItemPagerAdapter;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView imageView;
    View bottomSheetView;
    CardView cardBottomSheet;
    ImageView imgProfile;
    Button btnEditProfile;
    BottomSheetBehavior bottomSheetBehavior;
    Toolbar tool_bar,tool_bar1;
    AppBarLayout appBarLayout,appBarLayout1;
    TextView userName;


    int[] mDrawables = {
            R.drawable.profile_sample,
            R.drawable.profile_sample,
            R.drawable.profile_sample,
            R.drawable.profile_sample,
            R.drawable.profile_sample,
            R.drawable.profile_sample
    };
    int[] mColors = {
            R.drawable.image1,
            R.drawable.image2,
            R.drawable.image1,
            R.drawable.image4,

    };

    String[] url ={
            "http://cinetrooth.in/wp-content/uploads/2016/05/Suzi-Khan-Actress-Profile-and-Biography.jpg",
    };

    //   FloatingActionButton fab;

    private int RESULT_LOAD_IMG = 123;

    private String urlProfile = "https://4.bp.blogspot.com/-BHhUazKytmw/VbCfWPqrOJI/AAAAAAAAB7c/qj6WVX3du-s/s1600/51b91bba5a3fd9b6c8b9c53bc0ab6c65.jpg";
    private String child = "http://cinetrooth.in/wp-content/uploads/2016/05/Suzi-Khan-Actress-Profile-and-Biography.jpg";
    private String man = "https://www.profile4men.com/wp-content/uploads/2016/11/img-Rob_BW.jpg";
    private String oldPerson = "https://files.informabtl.com/uploads/2015/10/pablo-isla.jpg";
    private String school = "https://img3.stockfresh.com/files/k/kurhan/m/77/427335_stock-photo-school-boys.jpg";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);
        imageView = (ImageView) findViewById(R.id.bg_profile_image);
        cardBottomSheet = (CardView) findViewById(R.id.cardBottomSheet);
        userName = (TextView) findViewById(R.id.userName);
        //  fab=(FloatingActionButton)findViewById(R.id.fab);
        // Glide.with(this).load("http://www.illumni.co/wp-content/uploads/2014/06/No.-1.jpg").centerCrop().into(imageView);

        imgProfile = (ImageView) findViewById(R.id.imgProfile);
        bottomSheetView = (View) findViewById(R.id.nestedBottomSheet);
        bottomSheetBehavior = BottomSheetBehavior.from(bottomSheetView);
        btnEditProfile = (Button) findViewById(R.id.btnEditProfile);
        appBarLayout = (AppBarLayout) findViewById(R.id.appBarLayout);
        tool_bar = (Toolbar) findViewById(R.id.tool_bar);

        setSupportActionBar(tool_bar);
        setSupportActionBar(tool_bar1);

        appBarLayout1 = (AppBarLayout) findViewById(R.id.appBarLayout1);
        tool_bar1 = (Toolbar) findViewById(R.id.tool_bar1);

        tool_bar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);

        tool_bar1.setNavigationIcon(R.drawable.ic_close_black_24dp);
        btnEditProfile.setOnClickListener(this);

        imgProfile.setOnClickListener(this);
        bottomSheetBehavior.setPeekHeight(500);
        appBarLayout.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.trans_parent_bluelight));
        appBarLayout1.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.trans_parent_light));
        tool_bar1.setTitle("Cancel");
        setProfileImage(man, "David Beckham");

        tool_bar1.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
            }
        });

        tool_bar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        bottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                if (newState == BottomSheetBehavior.STATE_COLLAPSED) {
                    //    colorChange(R.color.trans_parent_bluedark, R.color.trans_parent, cardBottomSheet);
                    cardBottomSheet.setCardBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.trans_parent));
                    appBarLayout.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.trans_parent_bluelight));
                    imageView.setImageAlpha(225);
                   // imgProfile.setImageAlpha(150);
                    ///  fab.show();
                } else if (newState == BottomSheetBehavior.STATE_HIDDEN) {
                    cardBottomSheet.setCardBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorPrimaryDark));
                } else if (newState == BottomSheetBehavior.STATE_DRAGGING) {
                    cardBottomSheet.setCardBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorPrimaryDark));
                    //  colorChange(R.color.trans_parent, R.color.trans_parent_bluedark,cardBottomSheet);
                    imageView.setImageAlpha(150);
                   // imgProfile.setImageAlpha(225);
                    //  fab.hide();
                    appBarLayout.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.trans_parent_bluedark));
                }
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {

            }
        });


//        ItemPagerAdapter adapter = new ItemPagerAdapter(this,mDrawables);
//        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);
//        viewPager.setAdapter(adapter);

    }

    void setProfileImage(String url, String name) {
        Glide.with(this).load(url).centerCrop().into(imageView);
        //.placeholder(R.drawable.dummy)
        userName.setText(name);
        Glide.with(this).load(url).asBitmap().placeholder(R.drawable.profile).centerCrop().into(new BitmapImageViewTarget(imgProfile) {
        @Override
        protected void setResource(Bitmap resource) {
            RoundedBitmapDrawable circularBitmapDrawable =
                    RoundedBitmapDrawableFactory.create(getApplicationContext().getResources(), resource);
            circularBitmapDrawable.setCircular(true);
            imgProfile.setImageDrawable(circularBitmapDrawable);
        }
    });
}

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.imgProfile:
                showAlert();
                break;
            case R.id.btnEditProfile:
                showAlert();
                break;
            default:
                break;
        }
    }


    void showAlert() {
//        ,R.style.Theme_D1NoTitleDim
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);

        CharSequence[] charSequences = {"Mithali Raj", "Child", "Man", "Old person", "school", "Get Gallery"};
        alertDialogBuilder.setTitle("Change Profile");
        alertDialogBuilder.setItems(charSequences, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                switch (i) {
                    case 0:
                        setProfileImage(urlProfile, "Mithali Raj");
                        break;
                    case 1:
                        setProfileImage(child, "Betty Grace");
                        break;
                    case 2:
                        setProfileImage(man, "David Beckham");
                        break;
                    case 3:
                        setProfileImage(oldPerson, "John canady");
                        break;
                    case 4:
                        setProfileImage(school, "Williamson");
                        break;
                    case 5:
                     //   getGalleryImages();
                        break;
                    default:
                        break;
                }

            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();

//        WindowManager.LayoutParams lp = alertDialog.getWindow().getAttributes();
//        lp.dimAmount = 0.7f;
//        alertDialog.getWindow().setAttributes(lp);
//        alertDialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND);
    }

    private void getGalleryImages() {
        Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
        photoPickerIntent.setType("image/*");
        startActivityForResult(photoPickerIntent, RESULT_LOAD_IMG);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK){
            Uri imageUri=data.getData();
            setProfileImageGallery(imageUri,"Sample");
        }
    }

    private void setProfileImageGallery(Uri imageUri, String sample) {
        Glide.with(this).load(imageUri).centerCrop().into(imageView);
        userName.setText(sample);
//        .placeholder(R.drawable.dummy)
        Glide.with(this).load(imageUri).asBitmap().centerCrop().placeholder(R.drawable.profile).into(new BitmapImageViewTarget(imgProfile) {
            @Override
            protected void setResource(Bitmap resource) {
                RoundedBitmapDrawable circularBitmapDrawable =
                        RoundedBitmapDrawableFactory.create(getApplicationContext().getResources(), resource);
                circularBitmapDrawable.setCircular(true);
                imgProfile.setImageDrawable(circularBitmapDrawable);
            }
        });
    }

    void colorChange(int start, int end, final View view) {

        ValueAnimator valueAnimator = ValueAnimator.ofObject(new ArgbEvaluator(), start, end);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                view.setBackgroundColor((Integer) valueAnimator.getAnimatedValue());
            }
        });

        valueAnimator.setDuration(500);
        valueAnimator.start();
    }
}

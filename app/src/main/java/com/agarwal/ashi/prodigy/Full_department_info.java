package com.agarwal.ashi.prodigy;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class Full_department_info extends AppCompatActivity {
    String[] department={
            "The Editorial Team provides expert advice on content and encouraging submissions.It focuses not only on the writing part but also plays a major role in increasing technical awareness through their blogs and articles.They play a major role in identifyimg trending technical topics and making people aware of it through their attractive writing skills.",
            "The Design Team are responsible for choosing and ordering elements like images,colors,symbols and typography,to express  a message to people.Whatever be the event ,it is the design team that provides it an appearance. The team makes posters , and a lot such things to make the event more and more productive.",
            "The Public Relations team is mainly concerned about advertisements of the events , gathering sponsors and all that.It is through their public speaking skills along with the talent of convincing people makes all of it go possible .",
            "The Sponsorship team provides top-level endorsement of the rationale and objectives of a programme.The team represents the senior managers responsible for making the key investment decisions. They gather sponsors any fest or event to be conducted . ",
            "The Events Team is responsible for managing the entire contributors and is able to make everyone work together. It is they who set goals for all others to fulfill . They are the ones who comes up with new ideas ans the skills of handling those and even making them a success",
            "The Technical Team has a major role to play in enhancing coding skills. The team trains people on how to improvize on their technical skills as well as manages the technical part of an event, be it an app or a website.",
            "The App Development Team translates the requirements into a technical solution.They are also responsible for establishing and enforcing standards and practices with the development team.They provide live updates of the ongoing events and also all the related information to that event.It also accepts registrations and makes the process faster.",
            "The Web Development Team expedites online stategy by co-ordinating development priorities among all departments with a stake in the web .They design and maintain a stable technical environment for the hosting of a website.They are responsible for announcing results and giving information related to the event. ",
            "The Vfx Team is mainly involved with 3D animation.Sometimes the animator will create the image themselves, and other times they will use images provided by a character designer. All the events are made live by providing video to it and that is done by this team. ",
            "The CSR Team involves voluntary commitment of participants to include in their corporate practices economic,social and environmental criterias which are above and beyond other activities. This involves training and interaction with children of other schools to enhance their skills in all possible ways.",
            "The Membership is all about making more and more people connected with us. To make them aware of the functionality of the team and encourage greater participation among individuals. They work for expanding the team so that new upcoming talents can work in a innovative way."};
    String[] title={"Editorial Team",
            "Design Team",
            "Public Relations",
            "Sponsorship",
            "Events",
            "Technical",
            "App Development",
            "Web Development",
            "VFX",
            "CSR",
            "Membership"};
    int[] images_department={R.drawable.editorial_img,
            R.drawable.design_img,
            R.drawable.pr_img,R.drawable.sponsorship_img,
            R.drawable.events_img,
            R.drawable.technical_img,R.drawable.app_img,R.drawable.web_img,
            R.drawable.vfx_img,
            R.drawable.csr_img,
            R.drawable.member};
    String[] heads;
    ViewPager mViewPager;
    List<Details> mDetails = new ArrayList<>();
    Details[] details=new Details[200];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_department_info);
        Intent intent=getIntent();
        Bundle b=intent.getExtras();
        int position=b.getInt("position",0);
        String head=b.getString("heads");
        head=head.replaceAll("#11#","\n");
        heads=head.split("#111#");
        mViewPager=(ViewPager)findViewById(R.id.viewpager);
        for(int j=position;j<department.length;j++) {
            details[j] = new Details();
            details[j].set_id_Image(images_department[j]);
            details[j].setImage_name(department[j]);
            details[j].setTitle(title[j]);
            details[j].setHead(heads[j]);
            mDetails.add(details[j]);
        }
        for(int j=0;j<position;j++) {
            details[j] = new Details();
            details[j].set_id_Image(images_department[j]);
            details[j].setImage_name(department[j]);
            details[j].setTitle(title[j]);
            details[j].setHead(heads[j]);
            mDetails.add(details[j]);
        }
        FragmentManager fragmentManager = getSupportFragmentManager();
        mViewPager.setAdapter(new FragmentStatePagerAdapter(fragmentManager) {
            @Override
            public Fragment getItem(int position) {
                Details details3 = mDetails.get(position);
                ActionBar actionBar = getSupportActionBar();
                actionBar.setTitle("Departments");
                return SwipeFragment2.getImage(details3.get_id_Image(), details3.getImage_name(),details3.getTitle(),details3.getHead());
            }
            @Override
            public int getCount() {
                return mDetails.size();
            }
        });
    }
}

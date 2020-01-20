package com.science.app.sciencelab;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ShowDevicesFragment extends Fragment {
    private ArrayList<Item> deviceItems;
    DevicesAdapter adapter;
    LinearLayoutManager lm;

    public ShowDevicesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_show_devices, container, false);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Bundle bundle = getArguments();

        assert bundle != null;
        deviceItems = new MyDbHelper(getContext()).getAllItemForDepartment(bundle.getInt("num"));
//        MyDbHelper helper = new MyDbHelper(getContext());

        //helper.getAllItemForDepartment();


  /*      deviceItems.add(new Item(1,"Aneroid barometer","عبارة عن علبة معدنٌة مستدٌرة من النٌكل والفضة مفرغة تماما من الهواء فإذا زاد الضغط ٌضغط على\n" +
                "السطح المموج للعلبة المفرغة فتنخفض سطح العلبة وٌنخفض معه الساق والرافعة فٌتحرن المحور والمؤشر\n" +
                "المتصل به حركة دابرٌة أمام الدابرة المدرجة لٌعطى لٌمة الضغط، وإذا لل الضغط ٌرتفع سطح العلبة فٌرتفع\n" +
                "معه الساق والرافعة فٌتحرن المحور والمؤشر حركة دابرٌة فى عكس الاتجاه السابك.\n" +
                "وٌتصل بإحدى الماعدتٌن مؤشر ٌتحرن على التدرٌج\n" +
                "الموضوع على أسطوانة تبٌن الضغط مباشرة\n" +
                "- وظٌفته الربٌسٌة تسجٌل الضغط الجوي عند مستوى\n" +
                "البحر.",1,R.drawable.ic_mec));
        deviceItems.add(new Item(1,"hamza donkey","عبارة عن علبة معدنٌة مستدٌرة من النٌكل والفضة مفرغة تماما من الهواء فإذا زاد الضغط ٌضغط على\n" +
                "السطح المموج للعلبة المفرغة فتنخفض سطح العلبة وٌنخفض معه الساق والرافعة فٌتحرن المحور والمؤشر\n" +
                "المتصل به حركة دابرٌة أمام الدابرة المدرجة لٌعطى لٌمة الضغط، وإذا لل الضغط ٌرتفع سطح العلبة فٌرتفع\n" +
                "معه الساق والرافعة فٌتحرن المحور والمؤشر حركة دابرٌة فى عكس الاتجاه السابك.\n" +
                "وٌتصل بإحدى الماعدتٌن مؤشر ٌتحرن على التدرٌج\n" +
                "الموضوع على أسطوانة تبٌن الضغط مباشرة\n" +
                "- وظٌفته الربٌسٌة تسجٌل الضغط الجوي عند مستوى\n" +
                "البحر.",1,R.drawable.ic_electr));
        deviceItems.add(new Item(1,"shorafa bitch","عبارة عن علبة معدنٌة مستدٌرة من النٌكل والفضة مفرغة تماما من الهواء فإذا زاد الضغط ٌضغط على\n" +
                "السطح المموج للعلبة المفرغة فتنخفض سطح العلبة وٌنخفض معه الساق والرافعة فٌتحرن المحور والمؤشر\n" +
                "المتصل به حركة دابرٌة أمام الدابرة المدرجة لٌعطى لٌمة الضغط، وإذا لل الضغط ٌرتفع سطح العلبة فٌرتفع\n" +
                "معه الساق والرافعة فٌتحرن المحور والمؤشر حركة دابرٌة فى عكس الاتجاه السابك.\n" +
                "وٌتصل بإحدى الماعدتٌن مؤشر ٌتحرن على التدرٌج\n" +
                "الموضوع على أسطوانة تبٌن الضغط مباشرة\n" +
                "- وظٌفته الربٌسٌة تسجٌل الضغط الجوي عند مستوى\n" +
                "البحر.",1,R.drawable.ic_biology));
*/


        new MyDbHelper(getContext());
        getArguments();




        RecyclerView rc = getView().findViewById(R.id.recyclerView);
        adapter = new DevicesAdapter(getContext(),deviceItems);

        lm= new LinearLayoutManager(getContext());
        lm.setOrientation(LinearLayoutManager.VERTICAL);
        rc.setLayoutManager(lm);
        rc.setAdapter(adapter);


    }
    public void refresh(int i){
        lm.scrollToPosition(0);
        deviceItems = new MyDbHelper(getContext()).getAllItemForDepartment(i);
        adapter.refresh(deviceItems);
    }
}

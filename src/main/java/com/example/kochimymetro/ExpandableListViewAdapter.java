package com.example.kochimymetro;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

public class ExpandableListViewAdapter  extends BaseExpandableListAdapter {


    String stations [] ={"Aluva","Pulinchodu","companyppadi","Ambattukavu","Muttom","Kalamassery","Cochin university"
            ,"Pathadippalam","Edappally","Changampuzha park","Palariattam","JLN stadium",

           "Kaloor","Lissie","MG Road","Maharajas college","Ernakulam South","Kadavanthara","Elamkulam","Vytila","Thaikkoodam","Petta"

    };

    String dec[][]={{"Bypass junction","Periyar Nagar","Aluva","PH:0484 2380980"},{"Kunnathery Thaikavu","Aluva","PH:0484 2380980"}

    ,{"SPW Road","Taikkattukara","Aluva","PH:0484 2880980"},{"Kunnather road","Ambattukavu","Aluva","PH:0484 2380980"},

            {"Muttom","Choornnikkara","PH:0484 2380980"},{"Railway Station Road","North Kalamassery","Ernakulam","PH:0484 2380980"},

            {"NH544","PKA","south Kalamassery","Ernakulam","PH:0484 2880980"},{"Edappally","Ernakulam","PH:0484 2880980"},{"Edappally","Kochi","PH:0484 2880980"},

            {"Palarivattom","Edappally Road","High Shool Junction","PH:0484 2880980"},{"Edappally road","Sonia Ngar","PH:0484 2880980"},

            {"Banerji Rd","Kaloor","ernakulam","PH:0484 2880980"},{"Kaloor","Kochi","PH:0484 2880980"},{"Banerji Rd","Ernakulam North","North Junction","PH:0484 2880980"},

            {"Padma Junction","North Kaloor","PH:0484 2880980"},{"Ernakulam","Shenoys","Kochi","PH:0484 2880980"},{"MG Road","Ernakulam South","PH:0484 2880980"},

            {"Kadavanthara Junction","Ernakulam","PH:0484 2880980"},{"SH15","Vytila","Ernakulam","PH:0484 2880980"},{"Vytila Mobility Hub","Ernakulam","PH:0484 2880980"},

            {"Panvel Highway","Vytila","Ernakulam","PH:0484 2880980"},{"Petta NH49","Maradu","PH:0484 2880980"}

    };
     Context context;
     public ExpandableListViewAdapter(Context context){

         this.context=context;
     }



    /**
     * Gets the number of groups.
     *
     * @return the number of groups
     */
    @Override
    public int getGroupCount()
    {
        return stations.length;
    }

    /**
     * Gets the number of children in a specified group.
     *
     * @param groupPosition the position of the group for which the children
     *                      count should be returned
     * @return the children count in the specified group
     */
    @Override
    public int getChildrenCount(int groupPosition)
    {

        return dec[groupPosition].length;
    }

    /**
     * Gets the data associated with the given group.
     *
     * @param groupPosition the position of the group
     * @return the data child for the specified group
     */
    @Override
    public Object getGroup(int groupPosition) {

        return stations[groupPosition] ;
    }

    /**
     * Gets the data associated with the given child within the given group.
     *
     * @param groupPosition the position of the group that the child resides in
     * @param childPosition the position of the child with respect to other
     *                      children in the group
     * @return the data of the child
     */
    @Override
    public Object getChild(int groupPosition, int childPosition) {


        return dec[groupPosition][childPosition];
    }

    /**
     * Gets the ID for the group at the given position. This group ID must be
     * unique across groups. The combined ID (see
     * {@link #getCombinedGroupId(long)}) must be unique across ALL items
     * (groups and all children).
     *
     * @param groupPosition the position of the group for which the ID is wanted
     * @return the ID associated with the group
     */
    @Override
    public long getGroupId(int groupPosition) {

        return groupPosition;
    }

    /**
     * Gets the ID for the given child within the given group. This ID must be
     * unique across all children within the group. The combined ID (see
     * {@link #getCombinedChildId(long, long)}) must be unique across ALL items
     * (groups and all children).
     *
     * @param groupPosition the position of the group that contains the child
     * @param childPosition the position of the child within the group for which
     *                      the ID is wanted
     * @return the ID associated with the child
     */
    @Override
    public long getChildId(int groupPosition, int childPosition)
    {
        return childPosition;
    }

    /**
     * Indicates whether the child and group IDs are stable across changes to the
     * underlying data.
     *
     * @return whether or not the same ID always refers to the same object
     * @see Adapter#hasStableIds()
     */
    @Override
    public boolean hasStableIds() {
        return false;
    }

    /**
     * Gets a View that displays the given group. This View is only for the
     * group--the Views for the group's children will be fetched using
     * {@link #getChildView(int, int, boolean, View, ViewGroup)}.
     *
     * @param groupPosition the position of the group for which the View is
     *                      returned
     * @param isExpanded    whether the group is expanded or collapsed
     * @param view  the old view to reuse, if possible. You should check
     *                      that this view is non-null and of an appropriate type before
     *                      using. If it is not possible to convert this view to display
     *                      the correct data, this method can create a new view. It is not
     *                      guaranteed that the convertView will have been previously
     *                      created by
     *                      {@link #getGroupView(int, boolean, View, ViewGroup)}.
     * @param parent        the parent that this view will eventually be attached to
     * @return the View corresponding to the group at the specified position
     */
    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View view, ViewGroup parent) {

       final TextView txtView = new TextView(context);
        txtView.setText(stations[groupPosition]);
        txtView.setPadding(100,0,0,0);
        txtView.setTextColor(Color.CYAN);
        txtView.setTextSize(25);


        return txtView;
    }

    /**
     * Gets a View that displays the data for the given child within the given
     * group.
     *
     * @param groupPosition the position of the group that contains the child
     * @param childPosition the position of the child (for which the View is
     *                      returned) within the group
     * @param isLastChild   Whether the child is the last child within the group
     * @param convertView   the old view to reuse, if possible. You should check
     *                      that this view is non-null and of an appropriate type before
     *                      using. If it is not possible to convert this view to display
     *                      the correct data, this method can create a new view. It is not
     *                      guaranteed that the convertView will have been previously
     *                      created by
     *                      {@link #getChildView(int, int, boolean, View, ViewGroup)}.
     * @param parent        the parent that this view will eventually be attached to
     * @return the View corresponding to the child at the specified position
     */
    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {


        final TextView txtView = new TextView(context);
        txtView.setText(dec[groupPosition][childPosition]);
        txtView.setPadding(100,0,0,0);
        txtView.setTextColor(Color.BLACK);
        txtView.setTextSize(20);
        txtView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,txtView.getText().toString(),Toast.LENGTH_SHORT).show();
            }
        });

        return txtView;
    }

    /**
     * Whether the child at the specified position is selectable.
     *
     * @param groupPosition the position of the group that contains the child
     * @param childPosition the position of the child within the group
     * @return whether the child is selectable.
     */
    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition)
    {
        return false;
    }
}

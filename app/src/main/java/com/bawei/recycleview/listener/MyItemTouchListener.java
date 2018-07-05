package com.bawei.recycleview.listener;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

public class MyItemTouchListener extends ItemTouchHelper.Callback {

    private MyItemMoveListener listener;

    public MyItemTouchListener(MyItemMoveListener listener) {
        this.listener = listener;
    }

    @Override
    public int getMovementFlags(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
        int swapFlag = ItemTouchHelper.UP | ItemTouchHelper.DOWN;
        return makeMovementFlags(swapFlag, 0);
    }

    @Override
    public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
        listener.onMove(viewHolder.getLayoutPosition(), target.getLayoutPosition());
        return true;
    }

    @Override
    public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {

    }
}

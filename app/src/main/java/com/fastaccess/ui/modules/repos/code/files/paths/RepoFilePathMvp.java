package com.fastaccess.ui.modules.repos.code.files.paths;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.fastaccess.data.dao.BranchesModel;
import com.fastaccess.data.dao.model.RepoFile;
import com.fastaccess.ui.base.mvp.BaseMvp;
import com.fastaccess.ui.widgets.recyclerview.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kosh on 20 Nov 2016, 11:10 AM
 */

interface RepoFilePathMvp {

    interface View extends BaseMvp.FAView {
        void onNotifyAdapter(@Nullable List<RepoFile> items, int page);

        void onItemClicked(@NonNull RepoFile model, int position);

        void onAppendPath(@NonNull RepoFile model);

        void onSendData();

        boolean canPressBack();

        void onBackPressed();

        void setBranchesData(@NonNull List<BranchesModel> branches, boolean firstTime);
    }

    interface Presenter extends BaseMvp.FAPresenter,
            BaseViewHolder.OnItemClickListener<RepoFile> {

        void onFragmentCreated(@Nullable Bundle bundle);

        @NonNull String getRepoId();

        @NonNull String getLogin();

        @Nullable String getPath();

        @NonNull ArrayList<RepoFile> getPaths();

        @NonNull ArrayList<BranchesModel> getBranches();

        String getDefaultBranch();
    }


}

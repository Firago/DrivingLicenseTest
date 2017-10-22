package com.dfirago.drivinglicensetest.dagger.modules;

import com.dfirago.drivinglicensetest.common.model.QuestionType;
import com.dfirago.drivinglicensetest.common.widget.AbstractQuestionView;
import com.dfirago.drivinglicensetest.common.widget.ImageQuestionView;
import com.dfirago.drivinglicensetest.common.widget.SimpleQuestionView;
import com.dfirago.drivinglicensetest.common.widget.VideoQuestionView;
import com.dfirago.drivinglicensetest.common.widget.builders.AbstractQuestionViewBuilder;
import com.dfirago.drivinglicensetest.common.widget.builders.ImageQuestionViewBuilder;
import com.dfirago.drivinglicensetest.common.widget.builders.SimpleQuestionViewBuilder;
import com.dfirago.drivinglicensetest.common.widget.builders.VideoQuestionViewBuilder;
import com.dfirago.drivinglicensetest.common.widget.factories.QuestionViewFactory;
import com.dfirago.drivinglicensetest.dagger.mappings.QuestionViewBuilderKey;
import com.dfirago.drivinglicensetest.dagger.mappings.QuestionViewKey;

import java.util.Map;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;

/**
 * Created by Dmytro Firago (firago94@gmail.com) on 10/11/2017.
 */
@Module
public abstract class QuestionViewModule {

    @Binds
    @IntoMap
    @QuestionViewKey(value = QuestionType.SIMPLE)
    abstract AbstractQuestionView simpleQuestionView(SimpleQuestionView view);

    @Binds
    @IntoMap
    @QuestionViewKey(value = QuestionType.IMAGE)
    abstract AbstractQuestionView imageQuestionView(ImageQuestionView view);

    @Binds
    @IntoMap
    @QuestionViewKey(value = QuestionType.VIDEO)
    abstract AbstractQuestionView videoQuestionView(VideoQuestionView view);

    @Binds
    @IntoMap
    @QuestionViewBuilderKey(value = QuestionType.SIMPLE)
    abstract AbstractQuestionViewBuilder simpleQuestionViewBuilder(SimpleQuestionViewBuilder builder);

    @Binds
    @IntoMap
    @QuestionViewBuilderKey(value = QuestionType.IMAGE)
    abstract AbstractQuestionViewBuilder imageQuestionViewBuilder(ImageQuestionViewBuilder builder);

    @Binds
    @IntoMap
    @QuestionViewBuilderKey(value = QuestionType.VIDEO)
    abstract AbstractQuestionViewBuilder videoQuestionViewBuilder(VideoQuestionViewBuilder builder);

    @Provides
    static QuestionViewFactory questionViewFactory(Map<QuestionType, AbstractQuestionViewBuilder> viewBuilderMap) {
        return new QuestionViewFactory(viewBuilderMap);
    }
}

package com.dfirago.dlt.dagger.modules;

import com.dfirago.dlt.common.model.AbstractQuestion;
import com.dfirago.dlt.common.model.ImageQuestion;
import com.dfirago.dlt.common.model.SimpleQuestion;
import com.dfirago.dlt.common.model.VideoQuestion;
import com.dfirago.dlt.common.utils.ColorProvider;
import com.dfirago.dlt.common.widget.AbstractQuestionView;
import com.dfirago.dlt.common.widget.ImageQuestionView;
import com.dfirago.dlt.common.widget.SimpleQuestionView;
import com.dfirago.dlt.common.widget.VideoQuestionView;
import com.dfirago.dlt.common.widget.builders.AbstractQuestionViewBuilder;
import com.dfirago.dlt.common.widget.builders.ImageQuestionViewBuilder;
import com.dfirago.dlt.common.widget.builders.SimpleQuestionViewBuilder;
import com.dfirago.dlt.common.widget.builders.VideoQuestionViewBuilder;
import com.dfirago.dlt.common.widget.utils.OptionsAdapter;
import com.dfirago.dlt.common.widget.utils.QuestionViewFactory;
import com.dfirago.dlt.dagger.mappings.QuestionViewBuilderKey;
import com.dfirago.dlt.dagger.mappings.QuestionViewKey;

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
    @QuestionViewKey(value = SimpleQuestion.class)
    abstract AbstractQuestionView simpleQuestionView(SimpleQuestionView view);

    @Binds
    @IntoMap
    @QuestionViewKey(value = ImageQuestion.class)
    abstract AbstractQuestionView imageQuestionView(ImageQuestionView view);

    @Binds
    @IntoMap
    @QuestionViewKey(value = VideoQuestion.class)
    abstract AbstractQuestionView videoQuestionView(VideoQuestionView view);

    @Binds
    @IntoMap
    @QuestionViewBuilderKey(value = SimpleQuestion.class)
    abstract AbstractQuestionViewBuilder simpleQuestionViewBuilder(SimpleQuestionViewBuilder builder);

    @Binds
    @IntoMap
    @QuestionViewBuilderKey(value = ImageQuestion.class)
    abstract AbstractQuestionViewBuilder imageQuestionViewBuilder(ImageQuestionViewBuilder builder);

    @Binds
    @IntoMap
    @QuestionViewBuilderKey(value = VideoQuestion.class)
    abstract AbstractQuestionViewBuilder videoQuestionViewBuilder(VideoQuestionViewBuilder builder);

    @Provides
    static QuestionViewFactory questionViewFactory(
            Map<Class<? extends AbstractQuestion>, AbstractQuestionViewBuilder> viewBuilderMap) {
        return new QuestionViewFactory(viewBuilderMap);
    }

    @Provides
    static OptionsAdapter optionsAdapter(ColorProvider colorProvider) {
        return new OptionsAdapter(colorProvider);
    }
}

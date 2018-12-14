package com.xun.tigablog.repository.es;

import com.xun.tigablog.domain.es.EsBlog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Blog 存储库.
 *
 * @author <a href="https://waylau.com">Way Lau</a>
 * @since 1.0.0 2017年3月12日
 */
public interface EsBlogRepository extends ElasticsearchRepository<EsBlog, String> {

    /**
     * 模糊查询(去重)
     *
     * @param title
     * @param Summary
     * @param content
     * @param tags
     * @param pageable
     * @return
     */
    Page<EsBlog> findDistinctEsBlogByTitleContainingOrSummaryContainingOrContentContainingOrTagsContaining(String title, String Summary, String content, String tags, Pageable pageable);

    EsBlog findByBlogId(Long blogId);
}

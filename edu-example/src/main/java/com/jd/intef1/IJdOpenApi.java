package com.jd.intef1;

import com.jd.domain.AreasInfo;

import java.util.List;

/**
 * <pre>
 * 描述
 * </pre>
 *
 * @author hui2.chen
 * @date 2019/9/2
 */
public interface IJdOpenApi {

    List<AreasInfo> getAreas() throws Exception;
}

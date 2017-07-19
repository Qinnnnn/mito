package de.tum.bgu.msm.io.input;

import com.pb.common.matrix.Matrix;
import de.tum.bgu.msm.MitoUtil;
import de.tum.bgu.msm.data.DataSet;
import omx.OmxFile;

/**
 * Created by Nico on 19.07.2017.
 */
public abstract class OMXReader extends AbstractInputReader{

    public OMXReader(DataSet dataSet) {
        super(dataSet);
    }

    protected Matrix readAndConvertToMatrix(String fileName, String matrixName) {
        OmxFile travelTimeOmx = new OmxFile(fileName);
        travelTimeOmx.openReadOnly();
        return MitoUtil.convertOmxToMatrix(travelTimeOmx.getMatrix(matrixName));
    }
}

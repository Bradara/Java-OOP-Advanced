package database;

import Utility.Constants;
import contracts.Modelable;
import contracts.Repository;
import exeptions.DuplicateModelException;
import exeptions.NonExistantModelException;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class RepositoryImpl<T extends Modelable> implements Repository {
    private HashMap<String, T> itemsByModel;

    public RepositoryImpl() {
        this.itemsByModel = new LinkedHashMap<>();
    }

    public HashMap<String, T> getItemsByModel() {
        return this.itemsByModel;
    }


    @Override
    public void Add(Modelable item) throws DuplicateModelException {
        if (this.itemsByModel.containsKey(item.getModel())) {
            throw new DuplicateModelException(Constants.DUPLICATE_MODEL_MESSAGE);
        }

        this.itemsByModel.put(item.getModel(), (T) item);
    }

    @Override
    public T GetItem(String model) throws NonExistantModelException {
        if (!this.itemsByModel.containsKey(model)) {
            throw new NonExistantModelException(Constants.NON_EXISTENT_MODEL_MESSAGE);
        }

        return this.itemsByModel.get(model);
    }

}

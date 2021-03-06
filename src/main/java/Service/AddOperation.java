package Service;

import Domain.Entity;
import Repository.IRepository;

public class AddOperation<T extends Entity> extends main.java.Service.UndoRedoOp<T> {

    private T addedEntity;

    public AddOperation(IRepository<T> repository, T addedEntity) {
        super(repository);
        this.addedEntity = addedEntity;
    }

    @Override
    public void doUndo() {
        repository.remove(addedEntity.getId());
    }

    @Override
    public void doRedo() {
        repository.add(addedEntity);
    }
}
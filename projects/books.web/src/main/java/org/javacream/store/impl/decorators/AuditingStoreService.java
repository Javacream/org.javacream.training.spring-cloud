package org.javacream.store.impl.decorators;

import java.util.Date;

import org.javacream.store.api.StoreService;
import org.springframework.stereotype.Component;

@Component
public class AuditingStoreService implements StoreService{
    public void setDelegate(StoreService delegate) {
        this.delegate = delegate;
    }

    private StoreService delegate;

    public int getStock(String category, String item) {
        System.out.println("calling getStock at " + new Date());
        return delegate.getStock(category, item);
    }

    @Override
    public void setStock(String category, String item, int stock) {
        delegate.setStock(category, item, stock);
    }

}

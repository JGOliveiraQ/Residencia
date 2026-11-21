package br.com.stockmanager.service;
import br.com.stockmanager.dto.*; import br.com.stockmanager.entity.Category; import br.com.stockmanager.exception.*; import br.com.stockmanager.repository.CategoryRepository; import org.springframework.stereotype.Service; import org.springframework.transaction.annotation.Transactional; import java.util.*;
@Service public class CategoryService{
 private final CategoryRepository repo; public CategoryService(CategoryRepository repo){this.repo=repo;}
 @Transactional(readOnly=true) public List<CategoryResponse> findAll(){return repo.findAll().stream().map(this::toResponse).toList();}
 @Transactional(readOnly=true) public Category get(Long id){return repo.findById(id).orElseThrow(()->new ResourceNotFoundException("Categoria não encontrada."));}
 @Transactional public CategoryResponse create(CategoryRequest r){String n=normalize(r.name()); if(repo.findByNormalizedName(n).isPresent())throw new DuplicateResourceException("Categoria já cadastrada."); return toResponse(repo.save(new Category(r.name().trim(),r.description())));}
 @Transactional public CategoryResponse update(Long id,CategoryRequest r){Category c=get(id);String n=normalize(r.name());repo.findByNormalizedName(n).filter(x->!x.getId().equals(id)).ifPresent(x->{throw new DuplicateResourceException("Categoria já cadastrada.");});c.setName(r.name().trim());c.setDescription(r.description());return toResponse(c);}
 @Transactional public void status(Long id,boolean active){get(id).setActive(active);}
 private String normalize(String s){return s.trim().toLowerCase(Locale.ROOT);} private CategoryResponse toResponse(Category c){return new CategoryResponse(c.getId(),c.getName(),c.getDescription(),c.isActive());}
}

SELECT c.item_id, c.item_name, c.rarity
FROM (SELECT item_id FROM item_info WHERE rarity = 'RARE') as a
JOIN item_tree b ON b.parent_item_id = a.item_id
JOIN item_info c ON b.item_id = c.item_id
ORDER BY c.item_id DESC

